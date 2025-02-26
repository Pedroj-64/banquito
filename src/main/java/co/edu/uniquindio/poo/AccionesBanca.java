package co.edu.uniquindio.poo;

public interface AccionesBanca {

    public void realizarTransaccion(double valor, BilleteraVirtual origen, BilleteraVirtual destino, Categoria categoria) throws Exception;
    final int costoPorTransaccion=200;

}
