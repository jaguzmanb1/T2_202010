package model.logic;

import java.util.Date;

public class Comparendo implements Comparable<Comparendo>{

	private int objectId;
	private Date fechaHora;
	private String claseVehiculo;
	private String tipoServicio;
	private String infraccion;
	private String descInfraccion;
	private String localidad;
	private Double longitud;
	private Double latitud;

	public Comparendo(int pObjectId, Date pFechaHora, String pClaseVehiculo, String pTipoServicio, String pInfraccion, String pDescInfraccion, String pLocalidad, double pLongitud, double pLatitud) {
		objectId = pObjectId;
		fechaHora = pFechaHora;
		claseVehiculo = pClaseVehiculo;
		tipoServicio = pTipoServicio;
		infraccion = pInfraccion;
		descInfraccion = pDescInfraccion;
		localidad = pLocalidad;
		latitud = pLatitud;
		longitud = pLongitud;
	}

	public double darLongitud() {
		return longitud;
	}
	
	public double darLatitud() {
		return latitud;
	}
	
	public int darObjectId() {
		return objectId;
	}

	public Date darFecha() {
		return fechaHora;
	}

	public String darClase() {
		return claseVehiculo;
	}

	public String tipoServicio() {
		return tipoServicio;
	}

	public String darInfraccion() {
		return infraccion;
	}

	public String darDescripcion() {
		return descInfraccion;
	}

	public String darLocalidad() {
		return localidad;
	}

	public String toString() {
		return Integer.toString(objectId) + " - " + fechaHora + " - " + infraccion + " - " + claseVehiculo + " - " + tipoServicio + " - " + localidad + " - " + longitud + " - " + latitud;
	}

	@Override
	public int compareTo(Comparendo o) {
		if (o.darObjectId() == this.objectId) {
			return 0;
		}
		else if(o.darObjectId() > this.objectId) {
			return -1;
		}
		return 1;

	}

}
