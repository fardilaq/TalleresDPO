package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {
	
	private Restaurante restaurante1 = new Restaurante();
    private ProductoMenu producto1 = new ProductoMenu("corral", 14000);;
    private ProductoMenu producto2 = new ProductoMenu("papas medianas", 5500);;
    private Ingrediente ingrediente1 = new Ingrediente("lechuga", 1000);;
    private Ingrediente ingrediente2 = new Ingrediente("tomate", 1200);;
    
	@BeforeEach
	void setUp( ) throws Exception
	{
		restaurante1.getMenuBase().add(producto1);
        restaurante1.getMenuBase().add(producto2);
        restaurante1.getIngredientes().add(ingrediente1);
        restaurante1.getIngredientes().add(ingrediente2);
	}

	@Test
    void testIniciarPedido() throws Exception {
        restaurante1.iniciarPedido("Felipe", "Calle187");
        Pedido pedido = restaurante1.getPedidoEnCurso();
        assertNotNull(pedido);
        assertEquals("Felipe", pedido.getNombreCliente());
    }

	@Test
    void testCerrarYGuardarPedido() throws Exception {
        restaurante1.iniciarPedido("Felipe", "Calle187");
        restaurante1.getPedidoEnCurso().agregarProducto(producto1);
        restaurante1.getPedidoEnCurso().agregarProducto(producto2);
        File tempFile = File.createTempFile("factura_test_", ".txt");
        tempFile.deleteOnExit();
        Pedido pedido = restaurante1.getPedidoEnCurso();
        pedido.guardarFactura(tempFile);
        restaurante1.cerrarYGuardarPedido();
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }

        String esperado =
            "Cliente: Felipe\n" +
            "Dirección: Calle187\n" +
            "----------------\n" +
            "corral\n" +
            "            14000\n" +
            "papas medianas\n" +
            "            5500\n" +
            "----------------\n" +
            "Precio Neto:  19500\n" +
            "IVA:          3705\n" +
            "Precio Total: 23205\n";

        assertEquals(esperado, contenido.toString());
    }


    @Test
    void testGetPedidoEnCurso() throws Exception {
        restaurante1.iniciarPedido("Ana", "Calle123");
        assertNotNull(restaurante1.getPedidoEnCurso());
    }

    @Test
    void testGetPedidos() {
        ArrayList<Pedido> pedidos = restaurante1.getPedidos();
        assertNotNull(pedidos);
        assertEquals(0, pedidos.size());
    }

    @Test
    void testGetMenuBase() {
        ArrayList<ProductoMenu> menu = restaurante1.getMenuBase();
        assertNotNull(menu);
        assertTrue(menu.contains(producto1));
    }

    @Test
    void testGetMenuCombos() {
        ArrayList<Combo> combos = restaurante1.getMenuCombos();
        assertNotNull(combos);
        assertEquals(0, combos.size());
    }

    @Test
    void testGetIngredientes() {
        ArrayList<Ingrediente> ing = restaurante1.getIngredientes();
        assertNotNull(ing);
        assertTrue(ing.contains(ingrediente1));
    }
}


