package Repaso;

import java.util.Objects;

public abstract class Trabajador implements Obra, Comparable<Trabajador>{
	private int edad;
	private int antiguedad;
	private String nombre;
	private String DNI;
	private TipoTrabajador tipo; 
	
	
	public Trabajador(int edad, int antiguedad, String nombre, String DNI, TipoTrabajador tipo) {
		super();
		this.edad = edad;
		this.antiguedad = antiguedad;
		this.nombre = nombre;
		this.DNI = DNI;
		this.tipo= tipo;
	}


	public int getEdad() {
		return edad;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public String getNombre() {
		return nombre;
	}


	public TipoTrabajador getTipo() {
		return tipo;
	}


	public String getDNI() {
		return DNI;
	}


	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(DNI, other.DNI);
	}


	@Override
	public String toString() {
		return "Trabajador con nombre " + nombre + " y DNI " + DNI + "";
	}
	
	
	
	
	

}
