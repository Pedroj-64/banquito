package co.edu.uniquindio.poo;

import java.security.SecureRandom;

public class BilleteraVirtual {

    private  String numBilletera;
    private double saldo;
    private Usuario usuario;

    public BilleteraVirtual(String numBilletera, double saldo, Usuario usuario) {
        this.numBilletera = numBilletera;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public void recargarBilletera(double saldoNuevo) {
        if(saldoNuevo>0){
            saldo+=saldoNuevo;
        }
        throw new RuntimeException("Saldo agregado no valido");
    }

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
