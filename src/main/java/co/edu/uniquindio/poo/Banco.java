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
