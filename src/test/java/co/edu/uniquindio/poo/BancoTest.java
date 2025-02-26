package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.time.LocalDateTime;

class BancoTest {
    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco("mi amigo");
    }

    @Test
    void testSetAndGetNombre() {
        banco.setNombre("Banco Central");
        assertEquals("Banco Central", banco.getNombre(), "El nombre del banco no coincide");
    }

    @Test
    void testSetAndGetListaUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        usuarios.add(new Usuario("Juan Pérez", "Calle 123", "12345678", "juan@email.com", "pass123"));
        usuarios.add(new Usuario("Ana Gómez", "Av. 456", "87654321", "ana@email.com", "pass456"));

        banco.setListaUsuarios(usuarios);
        assertEquals(usuarios, banco.getListaUsuarios(), "La lista de usuarios no coincide");
    }

    @Test
    void testSetAndGetListaBilleterasVirtuales() {
        LinkedList<BilleteraVirtual> billeteras = new LinkedList<>();
        Usuario usuario1 = new Usuario("Carlos López", "Calle A", "11111111", "carlos@email.com", "abc123");
        Usuario usuario2 = new Usuario("María Ruiz", "Av. B", "22222222", "maria@email.com", "xyz789");

        BilleteraVirtual billetera1 = new BilleteraVirtual(usuario1);
        BilleteraVirtual billetera2 = new BilleteraVirtual(usuario2);

        billeteras.add(billetera1);
        billeteras.add(billetera2);

        banco.setListaBilleterasVirtuales(billeteras);
        assertEquals(billeteras, banco.getListaBilleterasVirtuales(), "La lista de billeteras virtuales no coincide");
    }

    @Test
    void testSetAndGetListaTransacciones() {
        LinkedList<Transaccion> transacciones = new LinkedList<>();

        // Crear usuarios y billeteras
        Usuario usuario1 = new Usuario("Luis Torres", "Calle C", "33333333", "luis@email.com", "luis123");
        Usuario usuario2 = new Usuario("Sofía Méndez", "Av. D", "44444444", "sofia@email.com", "sofia456");

        BilleteraVirtual billeteraOrigen = new BilleteraVirtual(usuario1);
        BilleteraVirtual billeteraDestino = new BilleteraVirtual(usuario2);



        // Crear transacciones reales
        Transaccion t1 = new Transaccion(1500, billeteraOrigen, billeteraDestino, Categoria.OTROS);
        Transaccion t2 = new Transaccion(300, billeteraDestino, billeteraOrigen, Categoria.ROPA);

        transacciones.add(t1);
        transacciones.add(t2);

        banco.setListaTransacciones(transacciones);
        assertEquals(transacciones, banco.getListaTransacciones(), "La lista de transacciones no coincide");
    }
}


