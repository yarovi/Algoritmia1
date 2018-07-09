package EstructuraDatos;

public class Cola {

	Nodo raiz,fondo;
	int largo;
	public boolean estaVacia() {
		return raiz==fondo;
	}
	
	public boolean agregar(Object ele) {
		
		boolean agrego = false;
		Nodo nodoBuscado = buscar(ele);
		Nodo nuevoNodo = new Nodo(ele);
		if (nodoBuscado == null) {
			if (raiz == null) {
				raiz = nuevoNodo;
				fondo=nuevoNodo;
				largo++;
				
			} else {

//				agrego = nuevoNodo.agregarCola(nodo);
//				if (agrego == true) {
//					largo++;
//					nodo=nuevoNodo;
//					//nodo=nodo.siguienteNodo;
//				}
			}
		}
		return agrego;
	}
	
	public Nodo buscar(Object ele) {

		Nodo rpta = null;
		if (raiz != null) {
			rpta = raiz.buscar(ele);

		}
		return rpta;
	}
	public void imprimir() {
		Nodo actualNodo = raiz;
		int i=largo;
		while (actualNodo != null) {
			System.out.printf("[indice:%s] --- >[%s] \n",i, actualNodo.dato);
			actualNodo = actualNodo.siguienteNodo;
			i--;
		}
		System.out.println("\n");
	}
	public int totalElemento()
	{
		return largo;
	}
}
