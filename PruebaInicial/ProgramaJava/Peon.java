package Repaso;

public class Peon extends Trabajador implements Obra{
	public final double SALARIOBASEPEON= 600.0; 


	public Peon(int edad, int antiguedad, String nombre, String DNI, TipoTrabajador tipo) {
		super(edad, antiguedad, nombre, DNI, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSalario() {
		// TODO Auto-generated method stub
		return SALARIOBASEPEON + (this.getAntiguedad()/2); 
		
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
