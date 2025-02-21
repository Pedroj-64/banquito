package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Banco {
     private String nombre;
     private LinkedList<Usuario> listaUsuarios;
     private LinkedList<Transaccion> listaTransacciones;


    public Banco() {
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        if (!usuarioExiste(usuario.getCedula())){
            listaUsuarios.add(usuario);
            System.out.println("Usuario agregado: " + usuario.getNombre());
        }else{
            throw new RuntimeException("Usuario ya existe");
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
