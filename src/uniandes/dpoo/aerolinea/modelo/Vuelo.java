package uniandes.dpoo.aerolinea.modelo;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		super();
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new HashMap<>();
	}
	public String getFecha() {
		return fecha;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public Avion getAvion() {
		return avion;
	}
	public Collection<Tiquete> getTiquetes() {
	      return tiquetes.values();
	  }
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            int tarifa = calculadora.calcularTarifa(this, cliente);
            total += tarifa;
        }
        return total;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vuelo vuelo = (Vuelo) obj;
        return Objects.equals(fecha, vuelo.fecha) &&
               Objects.equals(ruta, vuelo.ruta) &&
               Objects.equals(avion, vuelo.avion);
    }

}
