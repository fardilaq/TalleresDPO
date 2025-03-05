package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copia = new int[arregloEnteros.length];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		copia[i] = arregloEnteros[i];
    	}
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copia = new String[arregloCadenas.length];
    	for (int i = 0; i<arregloCadenas.length; i++) {
    		copia[i] = arregloCadenas[i];
    	}
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad = arregloEnteros.length;
        return cantidad;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad = arregloCadenas.length;
        return cantidad;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] arreglo_aumentado = new int[arregloEnteros.length + 1];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		arreglo_aumentado[i] = arregloEnteros[i];
    	}
    	arreglo_aumentado[arregloEnteros.length] = entero;
    	arregloEnteros = arreglo_aumentado;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] arreglo_aumentado = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) {
            arreglo_aumentado[i] = arregloCadenas[i];
        }
        arreglo_aumentado[arregloCadenas.length] = cadena;
        arregloCadenas = arreglo_aumentado;
    	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int contador = 0;
    	for(int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] == valor) {
    			contador++;
    		}
    	}
    	int contador2 = 0;
    	int[] arreglo_reducido = new int[arregloEnteros.length - contador];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] != valor) {
    			arreglo_reducido[contador2] = arregloEnteros[i];
    			contador2++;
    		}
    	}
    	arregloEnteros = arreglo_reducido;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int contador = 0;
    	for(int i = 0; i < arregloCadenas.length; i++) {
    		if (arregloCadenas[i] == cadena) {
    			contador++;
    		}
    	}
    	int contador2 = 0;
    	String[] arreglo_reducido = new String[arregloCadenas.length - contador];
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (arregloCadenas[i] != cadena) {
    			arreglo_reducido[contador2] = arregloCadenas[i];
    			contador2++;
    		}
    	}
    	arregloCadenas = arreglo_reducido;

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0) {
            posicion = 0;
        } else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }

        int[] nuevo_arreglo = new int[arregloEnteros.length + 1];
        for (int i = 0; i < posicion; i++) {
            nuevo_arreglo[i] = arregloEnteros[i];
        }
        nuevo_arreglo[posicion] = entero;
        for (int i = posicion; i < arregloEnteros.length; i++) {
            nuevo_arreglo[i + 1] = arregloEnteros[i];
        }
        arregloEnteros = nuevo_arreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }

        int[] nuevo_arreglo = new int[arregloEnteros.length - 1];
        
        for (int i = 0; i < posicion; i++) {
            nuevo_arreglo[i] = arregloEnteros[i];
        }
        
        for (int i = posicion + 1; i < arregloEnteros.length; i++) {
            nuevo_arreglo[i - 1] = arregloEnteros[i]; 
        }
        arregloEnteros = nuevo_arreglo;

    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	arregloEnteros = new int[valores.length];
    	for (int i = 0; i < valores.length; i++) {
    		arregloEnteros[i] = (int) valores[i];
    	}

    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos ) {
    arregloCadenas = new String[objetos.length];
    for (int i = 0; i < objetos.length; i++) {
        if (objetos[i] != null) {
            arregloCadenas[i] = objetos[i].toString();
        } else {
            arregloCadenas[i] = "";
        }
    }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] = -arregloEnteros[i];
                }
        }

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	for (int i = 0; i < arregloEnteros.length - 1; i++) {
            for (int j = i + 1; j < arregloEnteros.length; j++) {
                if (arregloEnteros[i] > arregloEnteros[j]) {
                    int x = arregloEnteros[i];
                    arregloEnteros[i] = arregloEnteros[j];
                    arregloEnteros[j] = x;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	for (int i = 0; i < arregloCadenas.length - 1; i++) {
            for (int j = i + 1; j < arregloCadenas.length; j++) {
                if (arregloCadenas[i].compareTo(arregloCadenas[j]) > 0) {
                    String x = arregloCadenas[i];
                    arregloCadenas[i] = arregloCadenas[j];
                    arregloCadenas[j] = x;
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int contador = 0;
        String cadena_nueva = cadena.toLowerCase();
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].toLowerCase().equals(cadena_nueva)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int cantidad = contarApariciones(valor);
        if (cantidad == 0) {
            return new int[0];
        }
        int[] posiciones = new int[cantidad];
        int posicion_2 = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[posicion_2] = i;
                posicion_2++;
            }
        }
        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	 if (arregloEnteros.length == 0) {
    	        return new int[0];
    	    }

    	    int minimo = arregloEnteros[0];
    	    int maximo = arregloEnteros[0];
    	    for (int i = 1; i < arregloEnteros.length; i++) {
    	        if (arregloEnteros[i] < minimo) {
    	            minimo = arregloEnteros[i];
    	        }
    	        if (arregloEnteros[i] > maximo) {
    	            maximo = arregloEnteros[i];
    	        }
    	    }
    	return new int[]{minimo, maximo};
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
        for (int num : arregloEnteros) {
            if (histograma.containsKey(num)) {
                histograma.put(num, histograma.get(num) + 1);
            } else {
                histograma.put(num, 1);
            }
        }
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int repetidos = 0;
        boolean[] contado = new boolean[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (contado[i]) {
                continue;
            }

            int valor = arregloEnteros[i];
            int contador = 0;
            for (int j = i + 1; j < arregloEnteros.length; j++) {
                if (arregloEnteros[j] == valor) {
                    contador++;
                    contado[j] = true;
                }
            }
            if (contador > 0) {
                repetidos++;
            }
        }

        return repetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {
            return false; 
        }

        int[] copia1 = arregloEnteros.clone();
        int[] copia2 = otroArreglo.clone();

        ordenarArreglo(copia1);
        ordenarArreglo(copia2);
        for (int i = 0; i < copia1.length; i++) {
            if (copia1[i] != copia2[i]) {
                return false;
            }
        }
        return true;
    }
    private void ordenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = minimo + (int) (Math.random() * (maximo - minimo + 1));
        }
    }
    }


