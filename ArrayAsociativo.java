package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	//Métodos de instancia
	public int size(){
		int n = 0;
		Nodo aux = primero;
		while(aux != null){
			n++;
			aux = aux.sig;
		}
		return n;
	}
	
	public String get(String clave){
		Nodo aux = primero;
		String res;
		while(clave != aux.clave && aux != null){
			aux = aux.sig;
		}
		if(aux == null){
			throw new NoSuchElementException("Falla");
		}
		else{
			res = aux.valor;
			return res;
		}
	}
	
	
	
}
