package EstructuraDatos;

public class Cola {

	Nodo cabezita, colita;
	int largo;

	public boolean estaVacia() {
		return cabezita == colita;
	}

	public boolean encolar(Object ele) {

		boolean agrego = false;
		Nodo nodoBuscado = buscar(ele);
		Nodo nuevoNodo = new Nodo(ele);
		if (nodoBuscado == null) {
			if (cabezita == null) {
				cabezita = nuevoNodo;
				largo++;
			} else {
				agrego = cabezita.agregarCola(nuevoNodo);
				if (agrego == true) {
					largo++;
					colita = nuevoNodo;
				}
			}
		}
		return agrego;
	}

	public void desencolar() {
		
		if(estaVacia()) {
			largo--;
			System.out.printf("Cola Vacia. \n");}
		else {
			largo--;
			Nodo aux=cabezita;
			System.out.printf("elemento eliminado : %s\n",aux.dato);
			cabezita=aux.siguienteNodo;			
			desencolar();
			
		}
	}
	public Nodo buscar(Object ele) {

		Nodo rpta = null;
		if (cabezita != null) {
			rpta = cabezita.buscar(ele);

		}
		return rpta;
	}

	public void imprimir() {
		Nodo actualNodo = cabezita;
		int i = 0;
		while (actualNodo != null) {
			System.out.printf("[indice:%s] --- >[%s] \n", i, actualNodo.dato);
			actualNodo = actualNodo.siguienteNodo;
			i++;
		}
		System.out.println("\n");
	}

	public int totalElemento() {
		return largo;
	}
}
