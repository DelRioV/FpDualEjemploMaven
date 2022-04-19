package Herencia; /**
 * 
 * @author Pablo Salvador Del Rio Vergara -- 1ºDAM -- San Jose
 * 
 * @version 1.0
 */

class Empleado{
	private String nombre;
	private String cedula;
	private int edad;
	private boolean casado;
	private double salario;
	
	public Empleado(){
			
	}
	
	public Empleado(String nombre, String cedula, int edad, boolean casado, double salario){
		this.nombre = nombre;
		this.cedula = cedula;
		this.casado = casado;
		this.salario = salario;
		this.edad = edad;
		clasificarSegunEdad();
	}
	
	public void clasificarSegunEdad(){
		if(edad<=21 && edad>=18){
			System.out.println("Principiante");
		}
		else if(edad>=22 && edad<=35){
			System.out.println("Intermedio");
		}
		else if(edad>35 && edad<=45){
			System.out.println("Senior");
		}
		else{
			System.out.println("Edad no valida");
		}
	}

	public void imprimirDatos(){
		System.out.println(nombre+"/nNombre:"+cedula+"/nEdad:"+edad+"/nCasado:"+casado+"/nSalario:"+salario);
	}
	
	public void aumentarSalario(double porcentaje){
		salario=salario+(salario*(porcentaje/100));
		System.out.println("Salario actualizado a: "+salario);
	}
}