package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.UUID;

public class Banco {
     private String nombre;
     private LinkedList<Usuario> listaUsuarios;
     private LinkedList<Transaccion> listaTransacciones;
     private LinkedList<BilleteraVirtual> listaBilleterasVirtuales;


    public Banco() {
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
        this.listaBilleterasVirtuales = new LinkedList<>();
    }

    public void agregarUsuario(Usuario usuario) throws Exception{
        try{
            if (!usuarioExiste(usuario.getCedula())){
                listaUsuarios.add(usuario);
                BilleteraVirtual billeteraVirtualNueva = crearIdBilletera(usuario);
                System.out.println("Usuario agregado: " + usuario.getNombre() + "Billetera virtual creada con el id: " + billeteraVirtualNueva.getNumBilletera() );
            }else
                System.out.println("El usario fue agregado con anterioridad");
        }
        catch (NullPointerException es){
            throw new NullPointerException("El usuario no puede ser nulo");
        }
        catch (Exception e) {
            throw new RuntimeException("Error al crear al nuevo usuario" + e);
        }

    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuarioExiste(usuario.getCedula())){
            listaUsuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + usuario.getNombre());
        }else{
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

    private boolean usuarioExiste(String cedula){
        boolean existe=false;
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    public void crearBilletera(Usuario usuario) throws Exception {
        try {
            BilleteraVirtual nuevaBilletera = new BilleteraVirtual(usuario);
            nuevaBilletera.setNumBilletera(this.crearIdBilletera());
        } catch (NullPointerException e) {
            throw new RuntimeException("Usuario no puede ser nulo: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la billetera: " + e.getMessage(), e);
        }
    }


    private String crearIdBilletera(){

        return String.valueOf(UUID.randomUUID());
    }


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

    @Override
    public String toString() {
        return "Banco{}";
    }
}
