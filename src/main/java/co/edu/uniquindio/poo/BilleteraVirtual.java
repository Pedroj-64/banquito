package co.edu.uniquindio.poo;

import java.security.SecureRandom;

public class BilleteraVirtual {

    private  String numBilletera;
    private double saldo;
    private Usuario usuario;

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

    @Override
    public String toString() {
        return "BilleteraVirtual{" +
                "usuario=" + usuario +
                ", saldo=" + saldo +
                ", numBilletera='" + numBilletera + '\'' +
                '}';
    }
}
