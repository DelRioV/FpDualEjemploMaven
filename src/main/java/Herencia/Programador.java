package Herencia; /**
 * 
 * @author Pablo Salvador Del Rio Vergara -- 1ºDAM -- San Jose
 * 
 * @version 1.0
 * 
 */

import Herencia.Empleado;

public class Programador extends Empleado {
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;
	
	public Programador(){
		super();
	}
	
	public Programador(int lineasDeCodigoPorHora, String lenguajeDominante){
		super();
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}
}