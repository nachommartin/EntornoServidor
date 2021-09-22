package Repaso;

import java.util.Scanner;

public class RepasoMain {
	public static Scanner teclado = new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e = leerCadena("Diga el nombre de la empresa"); 
		String cif = leerCadena("Diga el CIF de la empresa"); 
		Empresa emp = new Empresa(e,cif);
		int opcion; 
		do {
			opcion =leerEntero("Bienvenido a " + e + "\nElija una opción:\n 1. Añadir trabajador \n 2. Borrar trabajador \n 3. Obtener masa salarial\n 4. Consultar empleados\n 5. Salir");
			switch (opcion) {
			case 1:
				String dni= leerCadena("Diga el dni"); 
				String nombre= leerCadena("Diga el nombre"); 
				int antiguedad= leerEntero("Diga la antigüedad");
				int edad= leerEntero("Diga la edad");
				TipoTrabajador tipo= leerTipo("Diga tipo de empleado: Subvencionado o No Subvencionado");
				String resp= leerCadena("¿Es capataz?"); 
				if (resp.toUpperCase().equals("SI")){
					int proyectos= leerEntero("Diga el número de proyectos");
					Capataz cp = new Capataz (edad,antiguedad,nombre,dni,tipo,proyectos);
					emp.anadirTrabajador(cp);
				}
				else {
					Peon pn = new Peon (edad,antiguedad,nombre,dni,tipo);
					emp.anadirTrabajador(pn);
				}
				break;
			case 2: 
				String dni2= leerCadena("Diga el dni"); 
				String nombre2= leerCadena("Diga el nombre"); 
				int antiguedad2= leerEntero("Diga la antigüedad");
				int edad2= leerEntero("Diga la edad");
				TipoTrabajador tipo2;
				tipo2 = leerTipo("Diga tipo de empleado: Subvencionado o No Subvencionado");
				String resp2= leerCadena("¿Es capataz?"); 
				if (resp2.toUpperCase().equals("SI")){
					int proyectos= leerEntero("Diga el número de proyectos");
					Capataz cp = new Capataz (edad2,antiguedad2,nombre2,dni2,tipo2,proyectos);
					try {
						emp.borrarTrabajador(cp);
					} catch (EmpresaException ee) {
						// TODO Auto-generated catch block
						System.out.println(ee);
					}
				}
				else {
					Peon pn = new Peon (edad2,antiguedad2,nombre2,dni2,tipo2);
					try {
						emp.borrarTrabajador(pn);
					} catch (EmpresaException ee) {
						// TODO Auto-generated catch block
						System.out.println(ee);
					}
				}
				break;
			case 3: 
				System.out.println(emp.obtenerMasaSalarial() + " euros");
				break;
			case 4: 
				try {
					System.out.println(emp.mostrarTrabajadores());
				} catch (EmpresaException ee) {
					// TODO Auto-generated catch block
					System.out.println(ee);
				} /* Muestra los trabajadores ordenados por DNI*/
				break;			
			}
		}
			while (opcion!=5);
		
	

	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		String cadena= (teclado.nextLine());
		return cadena;
	}	
	
	public static TipoTrabajador leerTipo(String msg)  {
		TipoTrabajador tipo;
		System.out.println(msg);
		String cadena= (teclado.nextLine());
		if (cadena.toUpperCase().equals("SUBVENCIONADO")){
			tipo=TipoTrabajador.SUBVENCIONADO; 
		}
		else {
			tipo=TipoTrabajador.NOSUBVENCIONADO; 
		}
		return tipo;
	}	
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		int aux= Integer.parseInt(teclado.nextLine());
		return aux;
	}

}
