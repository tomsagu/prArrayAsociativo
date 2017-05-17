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
		while(aux != null && clave != aux.clave){
			aux = aux.sig;
		}
		if(aux == null){
			throw new NoSuchElementException("Falla");
		}
		else{
			res = aux.valor;
		}
		return res;
	}
	
	public void put(String clave, String valor){
		Nodo aux = primero;
		while(aux != null && clave != aux.clave){
			aux = aux.sig;
			
		}
		if(aux == null){
			Nodo nuevo = new Nodo(clave, valor,primero);
			primero = nuevo;
		}else{
			aux.valor = valor;
		}
	}
	
	public String getOrElse(String clave, String valorPorDefecto){
		Nodo aux = primero;
		String res;
		while(aux != null && clave != aux.clave){
			aux = aux.sig;
		}
		if(aux == null){
			res = valorPorDefecto;
		}
		else{
			res = aux.valor;	
		}
		return res;
	}
	
	public boolean containsKey(String clave){
		Nodo aux = primero;
		while(aux != null && clave != aux.clave){
			aux = aux.sig;
		}
		return aux != null;
	}
	
	public boolean remove(String clave){
		boolean res = false;
		Nodo aux = primero;
		Nodo anterior = null;
		if(containsKey(clave)){
			while(aux != null && clave != aux.clave){
				anterior = aux;
				aux = aux.sig;
			}
			if(aux == primero){
				primero = aux.sig;
			}else{
				anterior.sig=aux.sig;
			}
			aux = null;
			res = true;
		}
		return res;
	}
	
	
}
