package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.UUID;

public class Banco {
    private String nombre;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Transaccion> listaTransacciones;
    private LinkedList<BilleteraVirtual> listaBilleterasVirtuales;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
        this.listaBilleterasVirtuales = new LinkedList<>();
    }

    public void agregarUsuario(Usuario usuario) throws Exception {
        try {
            if (!usuarioExiste(usuario.getCedula())) {
                listaUsuarios.add(usuario);
                BilleteraVirtual billeteraVirtualNueva = crearBilletera(usuario);
                System.out.println("Usuario agregado: " + usuario.getNombre() + ". Billetera virtual creada con el id: " + billeteraVirtualNueva.getNumBilletera());
            } else {
                System.out.println("El usuario ya fue agregado con anterioridad");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("El usuario no puede ser nulo");
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar el nuevo usuario: " + e.getMessage(), e);
        }
    }

    public BilleteraVirtual obtenerBilletera(String idBilletera) {
        BilleteraVirtual billeteraVirtualBuscada = null;
        for (BilleteraVirtual billetera : listaBilleterasVirtuales) {
            if (idBilletera.equals(billetera.getNumBilletera())) {
                billeteraVirtualBuscada = billetera;
                break;
            }
        }
        return billeteraVirtualBuscada;
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuarioExiste(usuario.getCedula())) {
            listaUsuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + usuario.getNombre());
        } else {
            throw new RuntimeException("Usuario no existe");
        }
    }

    public void actualizarUsuario(String cedula, String nuevoNombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                usuario.setNombre(nuevoNombre);
                System.out.println("Usuario actualizado: " + usuario);
                return;
            }
        }
        throw new RuntimeException("Usuario con cédula " + cedula + " no encontrado");
    }

    private boolean usuarioExiste(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public BilleteraVirtual crearBilletera(Usuario usuario) throws Exception {
        try {
            BilleteraVirtual nuevaBilletera = new BilleteraVirtual(usuario);
            nuevaBilletera.setNumBilletera(this.crearIdBilletera());
            listaBilleterasVirtuales.add(nuevaBilletera);
            return nuevaBilletera;
        } catch (NullPointerException e) {
            throw new RuntimeException("Usuario no puede ser nulo: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la billetera: " + e.getMessage(), e);
        }
    }

    public Usuario buscarUsuarioPorCedula(String cedula) throws Exception {
        try {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getCedula().equals(cedula)) {
                    return usuario;
                }
            }
            throw new IllegalArgumentException("Usuario con cédula " + cedula + " no encontrado");
        } catch (NullPointerException e) {
            throw new NullPointerException("La lista de usuarios o la cédula proporcionada son nulas");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el usuario: " + e.getMessage(), e);
        }
    }


    private String crearIdBilletera() {
        return UUID.randomUUID().toString();
    }


    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public LinkedList<BilleteraVirtual> getListaBilleterasVirtuales() {
        return listaBilleterasVirtuales;
    }

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
