package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	private Pedido pedido1 = new Pedido("Felipe", "Calle187");
	private Pedido pedido2 = new Pedido("David", "Calle170");
	private ProductoMenu producto1 = new ProductoMenu("corral",14000);
	private ProductoMenu producto2 = new ProductoMenu("papas medianas",5500);
	
	@BeforeEach
	void setUp( ) throws Exception
    {
        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);
    }
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	@Test
	void testGetIdPedido() {
	    

	    int id1 = pedido1.getIdPedido();
	    int id2 = pedido2.getIdPedido();

	    assertEquals(id1 + 1, id2, "El ID del segundo pedido debe ser uno más que el del primero.");
	}
	
	@Test
	void testgetNombreCliente()
	{
		assertEquals("Felipe",pedido1.getNombreCliente(),"El nombre no es correcto");
		assertEquals("David",pedido2.getNombreCliente(),"El nombre no es correcto");
	}
	
	@Test
	void testagregarProducto()
	{
		pedido2.agregarProducto(producto1);
		assertEquals(true,pedido2.productos.contains(producto1),"El producto no fue correctamente agregado");
	}
	
	@Test
	void testgetPrecioTotalPedido()
	{
		assertEquals(23205,pedido1.getPrecioTotalPedido(),"El precio no es el correcto");
	}
	
	@Test
	void testgetPrecioNetoPedido()
	{
		assertEquals(19500,pedido1.getPrecioNetoPedido(),"El precio no es el correcto");
	}
	
	@Test
	void testgetPrecioIVAPedido()
	{
		assertEquals(3705,pedido1.getPrecioIVAPedido(),"El precio no es el correcto");
	}
	
	@Test
	void testgenerarTextoFactura()
	{
		String texto1 = "Cliente: Felipe\nDirección: Calle187\n----------------\ncorral\n            14000\npapas medianas\n            5500\n----------------\nPrecio Neto:  19500\nIVA:          3705\nPrecio Total: 23205\n";
		assertEquals(texto1,pedido1.generarTextoFactura(),"La factura no es correcta");
	}
	@Test
	void testGuardarFactura() throws Exception
	{
	    File tempFile = File.createTempFile("factura", ".txt");
	    pedido1.guardarFactura(tempFile);
	    StringBuilder contenido = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            contenido.append(linea).append("\n");
	        }
	    }

	    String texto1 = "Cliente: Felipe\nDirección: Calle187\n----------------\ncorral\n            14000\npapas medianas\n            5500\n----------------\nPrecio Neto:  19500\nIVA:          3705\nPrecio Total: 23205\n";
	    assertEquals(texto1, contenido.toString(), "El contenido del archivo no es el correcto");
	    tempFile.delete();
	}
	
}
