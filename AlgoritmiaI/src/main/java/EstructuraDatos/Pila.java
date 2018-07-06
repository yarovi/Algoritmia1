package EstructuraDatos;
import EstructuraDatos.Nodo;

public class Pila {

	Nodo nodo;
	int largo;

	public boolean agregar(Object ele) {

		boolean agrego = false;
		Nodo nodoBuscado = buscar(ele);
		Nodo nuevoNodo = new Nodo(ele);
		if (nodoBuscado == null) {
			if (nodo == null) {
				nodo = nuevoNodo;
				largo++;

			} else {

				agrego = nodo.agregar(ele);
				if (agrego == true)
					largo++;

			}
		}

		return agrego;

	}

	public Nodo buscar(Object ele) {

		Nodo rpta = null;
		if (nodo != null) {
			rpta = nodo.buscar(ele);

		}
		return rpta;
	}

	public Nodo eliminar(Object ele) {
		Nodo eliminado = buscar(ele);
		if (eliminado != null) {
			eliminado.getAnteriorNodo().setSiguienteNodo(eliminado.getSiguienteNodo());
			eliminado.siguienteNodo.setAnteriorNodo(eliminado.getAnteriorNodo());
		}
		return eliminado;
	}

	public void imprimir() {
		Nodo actualNodo = nodo;

		while (actualNodo != null) {
			System.out.printf("[%s]-->", actualNodo.dato);
			actualNodo = actualNodo.siguienteNodo;
		}
		System.out.println("\n");
	}
	public int totalElemento()
	{
		return largo;
	}

}