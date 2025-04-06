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
    void testAgregarUsuario() throws Exception {
        banco.agregarUsuario(usuario);
        assertTrue(banco.getListaUsuarios().contains(usuario));
    }

    @Test
    void testObtenerBilletera() throws Exception {
        billetera = banco.crearBilletera(usuario);
        assertEquals(billetera, banco.obtenerBilletera(billetera.getNumBilletera()));
    }

    @Test
    void testEliminarUsuario() throws Exception {
        banco.agregarUsuario(usuario);
        banco.eliminarUsuario(usuario);
        assertFalse(banco.getListaUsuarios().contains(usuario));
    }

    @Test
    void testActualizarUsuario() throws Exception {
        banco.agregarUsuario(usuario);
        banco.actualizarUsuario("321", "Pedro Jose");
        assertEquals("Rodolfo", banco.buscarUsuarioPorCedula("321").getNombre());
    }

    @Test
    void testRealizarTransaccion() throws Exception {
        Usuario usuarioDestino = new Usuario("Santiago", "Carrera 69", "cedulita", "correito", "contraseñita");
        banco.agregarUsuario(usuario);
        banco.agregarUsuario(usuarioDestino);

        billetera = banco.crearBilletera(usuario);
        BilleteraVirtual billeteraDestino = banco.crearBilletera(usuarioDestino);

        billetera.recargarBilletera(50000); // Se deposita saldo inicial

        Categoria categoria = Categoria.FACTURAS; // Ajusta según tu implementación
        billetera.transferirDesdeBilletera(20000, billeteraDestino, categoria, banco);

        assertEquals(29800, billetera.getSaldo()); // Se verifica el saldo descontado
        assertEquals(20000, billeteraDestino.getSaldo()); // Se verifica el saldo recibido
    }

    @Test
    void testCrearBilletera() throws Exception {
        banco.agregarUsuario(usuario); // Primero se agrega el usuario al banco
        billetera = banco.crearBilletera(usuario); // Se crea la billetera

        assertNotNull(billetera, "La billetera no debería ser nula");
        assertEquals(usuario, billetera.getUsuario(), "La billetera debería estar asociada al usuario correcto");
        assertTrue(banco.getListaBilleterasVirtuales().contains(billetera), "La billetera debería estar en la lista del banco");
    }

    @Test
    void buscarUsuarioPorCedula() throws Exception {
        banco.agregarUsuario(usuario); // Se agrega el usuario al banco
        Usuario encontrado = banco.buscarUsuarioPorCedula("321");

        assertNotNull(encontrado, "El usuario no debería ser nulo");
        assertEquals(usuario, encontrado, "El usuario encontrado debería ser el mismo que el agregado");
    }

    @Test
    void crearIDRandom() {
        String id1 = banco.crearIDRandom();
        String id2 = banco.crearIDRandom();

        assertNotNull(id1, "El ID generado no debe ser nulo");
        assertNotNull(id2, "El ID generado no debe ser nulo");
        assertNotEquals(id1, id2, "Los IDs generados deben ser únicos");
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


