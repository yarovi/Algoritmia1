package EstructuraDatos;

//clase para represenatr el nodo de una lista
public class Nodo {
	Object dato;
	Nodo siguienteNodo;
	Nodo anteriorNodo;
	int posicion=0;
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
			rpta= true;
		}
		else if(comparador(siguienteNodo.dato, ele)>0) {
			Nodo temp=siguienteNodo;
			siguienteNodo=new Nodo(ele);
			siguienteNodo.anteriorNodo=temp.getAnteriorNodo();
			siguienteNodo.anteriorNodo.siguienteNodo=siguienteNodo;
			siguienteNodo.siguienteNodo=temp;
			temp.setAnteriorNodo(siguienteNodo);			
			rpta=true;
		}else
			rpta = siguienteNodo.agregar(ele);
		return rpta;
	}

	public boolean agregarPila(Nodo nodo) {

		boolean rpta = false;
		if (siguienteNodo == null) {
			siguienteNodo = nodo;
			return true;
		} else
			rpta = siguienteNodo.agregarPila(nodo);
		return rpta;
	}

	public boolean agregarCola(Nodo nodo) {

		boolean rpta = false;
		if (siguienteNodo == null) {
			siguienteNodo = nodo;
			return true;
		} else
			rpta = siguienteNodo.agregarPila(nodo);
		return rpta;
	}

	public Nodo buscar(Object ele) {

		Nodo rpta = null;
		/*
		 * estto es para cuando es un tipo de dato String
		 * */
		if (ele instanceof String) {

			String cadena2 = (String) dato;
			String cadena = (String) ele;
			posicion--;
			if (cadena.compareTo(cadena2) == 0) {
				/*
				 * si la comparacion es igual
				 * se devuelve la referencia del apuntador
				 * */
				rpta = this;
			} else if (siguienteNodo != null) {
				siguienteNodo.buscar(ele);
			}
		} 
		/*
		 * Esto es cuando es un tipo de datos Integer
		 * */
		else if (ele instanceof Integer) {
			Integer valor1 = (Integer) dato;
			Integer valor2 = (Integer) ele;
			posicion=posicion-1;
			if (valor1.compareTo(valor2) == 0) {
				/*
				 * si la comparacion es igual
				 * se devuelve la referencia del apuntador
				 * */
				
				rpta = this;
			} else if (siguienteNodo != null) {
				
				rpta=siguienteNodo.buscar(ele);
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
			Integer valor2 = (Integer) obj2;
			Integer valor = (Integer) obj;
			return valor.compareTo(valor2);
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

	public int getposNodo() {
		return posicion;
	}
	public void setposNodo(int pos) {
		posicion=pos;
	}
}
