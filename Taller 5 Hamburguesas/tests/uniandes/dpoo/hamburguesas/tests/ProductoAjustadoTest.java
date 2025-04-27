package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class ProductoAjustadoTest {
	private ProductoMenu productomenu1 = new ProductoMenu("corral",14000);
	private ProductoAjustado productoajustado1 = new ProductoAjustado(productomenu1);
	private ProductoAjustado productoajustado2 = new ProductoAjustado(productomenu1);;
	private Ingrediente tomate = new Ingrediente("tomate",1000);;
	private Ingrediente huevo = new Ingrediente("huevo",2500);
	private Ingrediente lechuga = new Ingrediente("lechuga",1000);;
	@BeforeEach
	void setUp( ) throws Exception
    {
        productoajustado1.agregarIngrediente(tomate);
        productoajustado2.agregarIngrediente(tomate);
        productoajustado2.agregarIngrediente(huevo);
        productoajustado2.eliminarIngrediente(lechuga);
        
    }
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void testgetNombre()
	{
		assertEquals("corral", productoajustado1.getNombre(), "El nombre del ingrediente no es el esperado. ");
	}
	
	@Test
	void testgetPrecio()
	{
		assertEquals(15000, productoajustado1.getPrecio(), "El precio no es el esperado. ");
	}
	
	@Test
	void testgenerarTextoFactura()
	{
		String texto1 ="corral    +tomate                1000            15000\n";
		String texto2 ="corral    +tomate                1000    +huevo                2500    -lechuga            17500\n";
		assertEquals(texto1,productoajustado1.generarTextoFactura(), "La factura no es correcta");
		assertEquals(texto2,productoajustado2.generarTextoFactura(), "La factura no es correcta");
	}
	
	@Test
	void testAgregarIngrediente() 
	{
		assertEquals(true, productoajustado1.agregados.contains(tomate), "El ingrediente no fue agregado correctamente.");
	}
	
	@Test
	void testEliminarIngrediente() {
		assertEquals(true, productoajustado2.eliminados.contains(lechuga), "El ingrediente no fue eliminado correctamente.");
	}

}
