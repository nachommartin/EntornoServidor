package Repaso;

public class Capataz extends Trabajador implements Obra{
	private int proyectos; 
	public final double SALARIOBASECAPATAZ= 600.0; 

	public Capataz(int edad, int antiguedad, String nombre, String DNI, TipoTrabajador tipo, int proyectos) {
		super(edad, antiguedad, nombre, DNI, tipo);
		this.proyectos = proyectos;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSalario() {
		int plus = (this.getAntiguedad()+this.proyectos)/2;
		double salario=	SALARIOBASECAPATAZ + plus;
		return salario; 
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Trabajador t) {
		int resul;
		if ( this.getDNI() == t.getDNI())
		resul=0;
		else
		{
		if ( this.getDNI() == t.getDNI())
		resul=1;
		else
		resul=-1;
		}
		return resul;
	}

}
