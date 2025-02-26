package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Clase Banco que implementa la interfaz AccionesBanca y maneja las operaciones
 * de un banco, como agregar usuarios, realizar transacciones y administrar billeteras virtuales.
 */
public class Banco implements AccionesBanca {
    private String nombre;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Transaccion> listaTransacciones;
    private LinkedList<BilleteraVirtual> listaBilleterasVirtuales;

    /**
     * Constructor de la clase Banco.
     * @param nombre Nombre del banco.
     */
    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
        this.listaBilleterasVirtuales = new LinkedList<>();
    }

    /**
     * Agrega un nuevo usuario al banco.
     * @param usuario Usuario a agregar.
     * @throws Exception si el usuario es nulo o ya existe.
     */
    public void agregarUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new NullPointerException("El usuario no puede ser nulo");
        }
        if (!usuarioExiste(usuario.getCedula())) {
            listaUsuarios.add(usuario);
            BilleteraVirtual billeteraVirtualNueva = crearBilletera(usuario);
            System.out.println("Usuario agregado: " + usuario.getNombre() + ". Billetera virtual creada con el id: " + billeteraVirtualNueva.getNumBilletera());
        } else {
            System.out.println("El usuario ya fue agregado con anterioridad");
        }
    }

    /**
     * Obtiene una billetera virtual por su ID.
     * @param idBilletera ID de la billetera.
     * @return La billetera virtual encontrada.
     * @throws RuntimeException si la billetera no es encontrada.
     */
    public BilleteraVirtual obtenerBilletera(String idBilletera) {
        for (BilleteraVirtual billetera : listaBilleterasVirtuales) {
            if (idBilletera.equals(billetera.getNumBilletera())) {
                return billetera;
            }
        }
        throw new RuntimeException("Billetera con ID " + idBilletera + " no encontrada");
    }

    /**
     * Elimina un usuario del banco.
     * @param usuario Usuario a eliminar.
     * @throws RuntimeException si el usuario no existe.
     */
    public void eliminarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new NullPointerException("El usuario no puede ser nulo");
        }
        if (usuarioExiste(usuario.getCedula())) {
            listaUsuarios.remove(usuario);
            for(BilleteraVirtual billetera : listaBilleterasVirtuales) {
                if(billetera.getUsuario() == usuario){
                    billetera.setEstado(false);
                }
            }
            System.out.println("Usuario eliminado: " + usuario.getNombre());
        } else {
            throw new RuntimeException("Usuario no existe");
        }
    }

    /**
     * Actualiza el nombre de un usuario.
     * @param cedula Cédula del usuario a actualizar.
     * @param nuevoNombre Nuevo nombre del usuario.
     * @throws RuntimeException si el usuario no es encontrado.
     */
    public void actualizarUsuario(String cedula, String nuevoNombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                usuario.setNombre(nuevoNombre);
                System.out.println("Usuario actualizado: " + usuario);
                break;
            }else{
                throw new RuntimeException("Usuario con cédula " + cedula + " no encontrado");
            }
        }

    }

    /**
     * Verifica si un usuario existe en el banco.
     * @param cedula Cédula del usuario.
     * @return true si el usuario existe, false en caso contrario.
     */
    private boolean usuarioExiste(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void realizarTransaccion(double valor, BilleteraVirtual origen, BilleteraVirtual destino, Categoria categoria) throws Exception {
        if (origen == null || destino == null) {
            throw new NullPointerException("Las billeteras origen y destino no pueden ser nulas");
        }

        if (!origen.isEstado() || !destino.isEstado()) {
            throw new Exception("Una de las billeteras está desactivada");
        }

        double valorTotalTransaccion = valor + costoPorTransaccion;

        if (origen.getSaldo() < valorTotalTransaccion) {
            throw new Exception("No tiene saldo suficiente para realizar la transacción");
        }

        if (!listaBilleterasVirtuales.contains(destino)) {
            throw new Exception("La billetera destino no se encuentra en la lista de billeteras virtuales");
        }

        origen.setSaldo(origen.getSaldo() - valorTotalTransaccion);
        destino.setSaldo(destino.getSaldo() + valor);

        Transaccion transaccion = new Transaccion(valor, origen, destino, categoria);
        transaccion.setID(crearIDRandom());
        listaTransacciones.add(transaccion);
    }



    /**
     * Crea una nueva billetera virtual para un usuario.
     * @param usuario Usuario para el que se creará la billetera.
     * @return La nueva billetera virtual creada.
     * @throws Exception si el usuario es nulo.
     */
    public BilleteraVirtual crearBilletera(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new NullPointerException("El usuario no puede ser nulo");
        }
        BilleteraVirtual nuevaBilletera = new BilleteraVirtual(usuario);
        nuevaBilletera.setNumBilletera(crearIDRandom());
        listaBilleterasVirtuales.add(nuevaBilletera);
        return nuevaBilletera;
    }

    /**
     * Busca un usuario por su cédula.
     * @param cedula Cédula del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception si el usuario no es encontrado.
     */
    public Usuario buscarUsuarioPorCedula(String cedula) throws Exception {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                for (BilleteraVirtual billetera : listaBilleterasVirtuales) {
                    if (billetera.getUsuario().equals(usuario) && billetera.isEstado()) {
                        return usuario;
                    }
                    throw new IllegalArgumentException("Usuario con cédula " + cedula + " no encontrado");
                }
            }
        }
        throw new IllegalArgumentException("Usuario con cédula " + cedula + " no encontrado");
    }


    public String crearIDRandom() {
        return UUID.randomUUID().toString();
    }

    // Getters y setters

    /**
     * Obtiene el nombre del banco.
     * @return Nombre del banco.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del banco.
     * @param nombre Nombre del banco.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de usuarios del banco.
     * @return Lista de usuarios.
     */
    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Establece la lista de usuarios del banco.
     * @param listaUsuarios Lista de usuarios.
     */
    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Obtiene la lista de transacciones del banco.
     * @return Lista de transacciones.
     */
    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * Establece la lista de transacciones del banco.
     * @param listaTransacciones Lista de transacciones.
     */
    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    /**
     * Obtiene la lista de billeteras virtuales del banco.
     * @return Lista de billeteras virtuales.
     */
    public LinkedList<BilleteraVirtual> getListaBilleterasVirtuales() {
        return listaBilleterasVirtuales;
    }

    /**
     * Establece la lista de billeteras virtuales del banco.
     * @param listaBilleterasVirtuales Lista de billeteras virtuales.
     */
    public void setListaBilleterasVirtuales(LinkedList<BilleteraVirtual> listaBilleterasVirtuales) {
        this.listaBilleterasVirtuales = listaBilleterasVirtuales;
    }



    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", listaUsuarios=" + listaUsuarios +
                ", listaTransacciones=" + listaTransacciones +
                ", listaBilleterasVirtuales=" + listaBilleterasVirtuales +
                '}';
    }
}

