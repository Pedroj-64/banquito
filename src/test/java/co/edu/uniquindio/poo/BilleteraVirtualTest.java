package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BilleteraVirtualTest {
    //XD

    private Banco banco;
    private BilleteraVirtual billeteraOrigen;
    private BilleteraVirtual billeteraDestino;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() throws Exception {
        Banco banco = new Banco("Banco Prueba");
        Usuario usuario1 = new Usuario("Juan Pérez", "123456","asdasd","Asasa","asas");
        Usuario usuario2 = new Usuario("María López", "654321","asdasd","Asasa","asas");

        BilleteraVirtual billeteraOrigen = new BilleteraVirtual(usuario1);
        BilleteraVirtual billeteraDestino = new BilleteraVirtual(usuario2);

        billeteraOrigen.setSaldo(10000);
        billeteraDestino.setSaldo(5000);

        banco.getListaBilleterasVirtuales().add(billeteraOrigen);
        banco.getListaBilleterasVirtuales().add(billeteraDestino);
    }

    @Test
    void transferenciaGuardadaEnHistorial() throws Exception {

        billeteraOrigen.transferirDesdeBilletera(5000, billeteraDestino, Categoria.OTROS, banco);

        assertEquals(4800, billeteraOrigen.getSaldo()); // 10000 - (5000 + 200 de comisión)
        assertEquals(10000, billeteraDestino.getSaldo()); // 5000 + 5000

        assertEquals(1, banco.getListaTransacciones().size());
    }

}
