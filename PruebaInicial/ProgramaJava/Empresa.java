package Repaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Empresa {
private String nombre;
private String CIF; 
private ArrayList<Trabajador> trabajadores;


public Empresa(String nombre, String CIF) {
	super();
	this.nombre = nombre;
	this.CIF  = CIF;
	trabajadores = new ArrayList<Trabajador>();

}


public void anadirTrabajador(Trabajador t1) {
	trabajadores.add(t1);
}

public void borrarTrabajador(Trabajador t1) throws EmpresaException{
	int pos = this.trabajadores.indexOf(t1);
	if (pos != -1) trabajadores.remove(t1);
	else throw new EmpresaException("Trabajador no encontrado");
}


public double obtenerMasaSalarial() {
	double suma=0;
	Iterator<Trabajador>it =trabajadores.iterator();
	while(it.hasNext()) {
		Trabajador aux=it.next();
		suma= suma + aux.calcularSalario();
	}
	return suma;
}

public String mostrarTrabajadores() throws EmpresaException {
	Collections.sort(trabajadores);
	StringBuilder cadena= new StringBuilder();
	int contador=0; 
	Iterator<Trabajador>it =trabajadores.iterator();
	while(it.hasNext()) {
		Trabajador aux=it.next();
        cadena.append(aux.toString()+"\n");
        contador++; 
	}
	if (contador<=0) {
		throw new EmpresaException("No hay trabajadores");
		}
	return cadena.toString();
	}





}
