package co.edu.uniquindio.poo;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BilleteraVirtual {

    private  String numBilletera;
    private double saldo;
    private Usuario usuario;
    private boolean estado;
    private LinkedList<Transaccion>transacciones;

    //Se supon que esta clase tiene que implementar accionesBanca por que tambient transfiere dinero no olvidar eso
    //IMPORTANTE



    public BilleteraVirtual(Usuario usuario) {
        this.usuario = usuario;
        this.estado=true;
    }

    /**
     * Metodo que permite recargar la billetera
     * @param saldoNuevo
     */
    public void recargarBilletera(double saldoNuevo) {
        try {
            if (saldoNuevo >= 0) {
                saldo += saldoNuevo;
                System.out.println("Saldo recargado exitosamente: " + saldoNuevo);
            } else {
                throw new IllegalArgumentException("Saldo agregado no válido: " + saldoNuevo);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Metodo para tranferir directamente desde la billetera a otra
     * @param valor
     * @param destino
     * @param categoria
     * @param banco
     * @throws Exception
     */
    public void transferirDesdeBilletera(double valor, BilleteraVirtual destino, Categoria categoria, Banco banco) throws Exception {
        if(banco==null) {
            throw new IllegalArgumentException("El banco no puede ser nulo");
        }
        banco.realizarTransaccion(valor, this, destino, categoria);
    }

    /// Getters y Setters
    public String getNumBilletera() {
        return numBilletera;
    }

    public void setNumBilletera(String numBilletera) {
        this.numBilletera = numBilletera;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BilleteraVirtual{" +
                "numBilletera='" + numBilletera + '\'' +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                ", estado=" + estado +
                ", transacciones=" + transacciones +
                '}';
    }
}
