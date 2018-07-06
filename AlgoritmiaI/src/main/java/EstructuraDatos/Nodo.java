package EstructuraDatos;

//clase para represenatr el nodo de una lista
public class Nodo {

	Object dato;
	Nodo siguienteNodo;
	Nodo anteriorNodo;

	public Nodo(Object x_dato) {
		this(x_dato, null);
	}

	public Nodo(Object datos, Nodo x_Nodo) {
		this.dato = datos;
		siguienteNodo = x_Nodo;
	}

	// devuelve la referencia a datos en el nodo
	public Object ObtenerObjeto() {
		return dato;
	}

	// devuelve la referencia al siguiente nodod de la lista
	Nodo obtenerSiguiente() {
		return siguienteNodo;
	}

	public boolean agregar(Object ele) {

		boolean rpta = false;
		if (siguienteNodo == null) {
			siguienteNodo = new Nodo(ele);
			siguienteNodo.anteriorNodo = this;
			return  true;
		}else
			rpta=siguienteNodo.agregar(ele);
		return rpta;
	}

	public Nodo buscar(Object ele) {

		Nodo rpta = null;

		if (ele instanceof String) {

			String cadena2 = (String) dato;
			String cadena = (String) ele;
			if (cadena.compareTo(cadena2) == 0) {
				rpta = this;
			} else if (siguienteNodo != null) {
				rpta = siguienteNodo.buscar(ele);
			}
		} else if (ele instanceof Integer) {
			Integer valor1 = (Integer) dato;
			Integer valor2 = (Integer) ele;
			if (valor1.compareTo(valor2) == 0) {

				rpta = this;
			} else if (siguienteNodo != null){
				rpta = siguienteNodo.buscar(ele);
			}
		}

		return rpta;
	}

	public Nodo eliminar(Object ele) {

		Nodo rpta = null;

		if (dato == ele) {
			rpta = siguienteNodo.eliminar(ele);
		}
		return rpta;
	}

	public int comparador(Object obj, Object obj2) {
		if (obj instanceof String) {

			String cadena2 = (String) obj2;
			String cadena = (String) obj;
			return cadena.compareTo(cadena2);
		} else if (obj instanceof Integer) {
			Integer valor1 = (Integer) obj;
			Integer valor2 = (Integer) obj2;
			return valor1.compareTo(valor2);
		}

		return 0;

	}

	public Nodo getSiguienteNodo() {
		return siguienteNodo;
	}

	public void setSiguienteNodo(Nodo siguienteNodo) {
		this.siguienteNodo = siguienteNodo;
	}

	public Nodo getAnteriorNodo() {
		return anteriorNodo;
	}

	public void setAnteriorNodo(Nodo anteriorNodo) {
		this.anteriorNodo = anteriorNodo;
	}

}
