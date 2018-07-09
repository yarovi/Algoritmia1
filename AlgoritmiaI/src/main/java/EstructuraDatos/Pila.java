package EstructuraDatos;

import EstructuraDatos.Nodo;

public class Pila {

	Nodo nodo;
	int largo;
	Nodo nodoActual;	
	public Pila() {
		nodoActual=null;
	}
	public boolean agregar(Object ele) {
		boolean agrego = false;
		Nodo nodoBuscado = buscar(ele);
		Nodo nuevoNodo = new Nodo(ele);
		if (nodoBuscado == null) {
			if (nodo == null) {
				nodo = nuevoNodo;
				largo++;
			} else {
				agrego = nuevoNodo.agregarPila(nodo);
				
				if (agrego == true) {
					largo++;
					nodo = nuevoNodo;
				}
			}			
		}
		nodoActual=nodo;
		return agrego;
	}
	public Nodo buscar(Object ele) {

		Nodo rpta = null;
		if (nodo != null) {
			rpta = nodo.buscar(ele);}
		return rpta;
	}
	public Nodo eliminar() {

		Nodo eliminado = buscar(nodo.dato);
		if (eliminado.getSiguienteNodo() == null) {
			nodo=null;
			largo--;
		} else {
			nodo = nodo.getSiguienteNodo();
			largo--;
		}
		nodoActual=nodo;
		return eliminado;
	}

	public void imprimir() {
		Nodo noddoAux = nodo;
		int i = largo;
		while (noddoAux != null) {
			System.out.printf("{%s} --- >[%s] \n", i, noddoAux.dato);
			noddoAux = noddoAux.siguienteNodo;
			i--;
		}
		System.out.println("Pila Origninal");
		System.out.println("\n");
	}

	public int totalElemento() {
		return largo;
	}
	public Object obtenerNodo() {
		
		if(nodoActual==null)
		{	nodoActual=nodo;}
		Nodo nodoTemporal = nodo;
		Nodo temp = nodoTemporal.siguienteNodo;
		nodo = temp;
		return nodoTemporal.dato;
	}
	public Nodo getNodoBase() {
		return nodo;
	}
	public void actualizarnodoBase() {
		nodo=nodoActual;
	}

}