package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public static final double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) (costoBase * (1 - descuento));
        int impuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + impuestos;
    }


    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
    protected int calcularDistanciaVuelo(Ruta ruta) {
        Aeropuerto origen = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();
        return Aeropuerto.calcularDistancia(origen, destino);
    }
}
	