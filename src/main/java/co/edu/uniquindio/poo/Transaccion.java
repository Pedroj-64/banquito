package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Transaccion {

    private String ID;
    private LocalDateTime fecha;
    private double valor;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;
    private Categoria categoria;


    public Transaccion(double valor,BilleteraVirtual origen, BilleteraVirtual destino, Categoria categoria) {
        this.valor = valor;
        this.origen = origen;
        this.destino = destino;
        this.categoria = categoria;
        fecha = LocalDateTime.now();


    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BilleteraVirtual getOrigen() {
        return origen;
    }

    public void setOrigen(BilleteraVirtual origen) {
        this.origen = origen;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public BilleteraVirtual getDestino() {
        return destino;
    }

    public void setDestino(BilleteraVirtual destino) {
        this.destino = destino;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "Transaccion{" +
                "ID='" + ID + '\'' +
                ", fecha=" + fecha +
                ", valor=" + valor +
                ", origen=" + origen +
                ", destino=" + destino +
                ", categoria=" + categoria +
                '}';
    }
}
