package uniandes.dpoo.hamburguesas.mundo;

import java.util.ArrayList;

/**
 * Un producto ajustado es un producto para el cual el cliente solicitó alguna modificación.
 */
public class ProductoAjustado implements Producto
{
    /**
     * El producto base que el cliente sobre el cual el cliente quiere hacer ajustes
     */
    private ProductoMenu productoBase;

    /**
     * La lista de ingrediente que el usuario quiere agregar. El mismo ingrediente puede aparecer varias veces.
     */
    
    //Cambio la visibilidad para que se pueda acceder
    public ArrayList<Ingrediente> agregados;

    /**
     * La lista de ingrediente que el usuario quiere eliminar.
     */
    //Cambio la visibilidad para que se pueda acceder
    public ArrayList<Ingrediente> eliminados;

    /**
     * Construye un nuevo producto ajustado a partir del producto base y sin modificaciones
     * @param productoBase El producto base que se va a ajustar
     */
    public ProductoAjustado( ProductoMenu productoBase )
    {
        this.productoBase = productoBase;
        agregados = new ArrayList<Ingrediente>( );
        eliminados = new ArrayList<Ingrediente>( );
    }

    @Override
    public String getNombre( )
    {
        return productoBase.getNombre( );
    }

    /**
     * Retorna el precio del producto ajustado, que debe ser igual al del producto base, sumándole el precio de los ingredientes adicionales.
     */
    @Override
    public int getPrecio( )
    {
    	int precio = productoBase.getPrecio();
        for (Ingrediente ing : agregados) {
            precio += ing.getCostoAdicional();
        }
        return precio;
    }

    /**
     * Genera el texto que debe aparecer en la factura.
     * 
     * El texto incluye el producto base, los ingredientes adicionales con su costo, los ingredientes eliminados, y el precio total
     */
    @Override
    public String generarTextoFactura( )
    {
    	//Se agregó .getNombre() al lado de producto base
        StringBuffer sb = new StringBuffer( );
        sb.append( productoBase.getNombre() );
        for( Ingrediente ing : agregados )
        {
            sb.append( "    +" + ing.getNombre( ) );
            sb.append( "                " + ing.getCostoAdicional( ) );
        }
        for( Ingrediente ing : eliminados )
        {
            sb.append( "    -" + ing.getNombre( ) );
        }

        sb.append( "            " + getPrecio( ) + "\n" );

        return sb.toString( );
    }
    //Se agregan 2 funciones para poder modificar las ArrayList de los ingredientes agregados y eliminados respectivamente
    
    public void agregarIngrediente(Ingrediente ingrediente) {
        agregados.add(ingrediente);
    }

    public void eliminarIngrediente(Ingrediente ingrediente) {
        eliminados.add(ingrediente);
    }

}
