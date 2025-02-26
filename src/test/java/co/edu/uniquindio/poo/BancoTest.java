package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.time.LocalDateTime;

class BancoTest {
    private Banco banco;
    private Usuario usuario;
    private BilleteraVirtual billetera;

    @BeforeEach
    void setUp() {
        banco = new Banco("Banco Test");
        usuario = new Usuario("Rodolfo", "Avenida 69", "321", "correito", "contraseñita");
    }
    private Banco banco;

    @Test
    void agregarUsuario() {
    }

    @Test
    void obtenerBilletera() {
    }

    @Test
    void eliminarUsuario() {
    }

    @Test
    void actualizarUsuario() {
    }

    @Test
    void realizarTransaccion() {
    }

    @Test
    void crearBilletera() {
    }

    @Test
    void buscarUsuarioPorCedula() {
    }

    @Test
    void crearIDRandom() {
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


