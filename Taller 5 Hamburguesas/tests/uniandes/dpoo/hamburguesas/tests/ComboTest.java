package uniandes.dpoo.hamburguesas.tests;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();;
	private Combo combo1;
	private ProductoMenu productomenu1 = new ProductoMenu("corral",14000);
	private ProductoMenu productomenu2 = new ProductoMenu("papas medianas",5500);
	private ProductoMenu productomenu3 = new ProductoMenu("gaseosa",5000);
	
	
	
	@BeforeEach
	void setUp( ) throws Exception
    {
		itemsCombo.add(productomenu1);
		itemsCombo.add(productomenu2);
		itemsCombo.add(productomenu3);
		
		combo1 = new Combo("corral",0.10,itemsCombo);
        
    }
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void testgetNombre()
	{
		assertEquals("corral", combo1.getNombre(),"El nombre no es correcto");
	}
	
	@Test 
	void testgetPrecio()
	{
		assertEquals(22050, combo1.getPrecio(),"El precio no es correcto");
	}
	
	@Test
	void testgenerarTextoFactura()
	{
		String texto1 = "Combo corral\n Descuento: 10.0%\n            22050\n";
		assertEquals(texto1, combo1.generarTextoFactura(),"La factura no es correcta");
	}
	

}
