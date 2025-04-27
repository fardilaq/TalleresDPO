package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	private ProductoMenu productomenu1;
	
	@BeforeEach
	void setUp( ) throws Exception
    {
        productomenu1 = new ProductoMenu( "corral", 14000 );
    }
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void testGetNombre() 
	{
		assertEquals( "corral", productomenu1.getNombre( ), "El nombre del ingrediente no es el esperado." );
	}
	
	@Test
	void testGetPrecio()
	{
		assertEquals(14000, productomenu1.getPrecio(), "El precio no es el Correcto." );
	}
	@Test
	void testgenerarTextoFactura()
	{
		String texto = "corral\n            14000\n";
		assertEquals(texto, productomenu1.generarTextoFactura(),"La factura no se generó bien");
	}
}
	

