package EstructuraDatos;

//definiendo la clase lista
public class Lista {

	private Nodo primerNodo;
	private Nodo ultimoNodo;
	private String nombre; // cadena como "lista", utilizada para imprimir

	// el constructor crea una Lista vac�a con el nombre "lista"
	public Lista() {
		this("lista");
	} // fin del constructor de Lista sin argumentos

	// el constructor crea una Lista vac�a con un nombre
	public Lista(String nombreLista) {
		nombre = nombreLista;
		primerNodo = ultimoNodo = null;
	} // fin del constructor de Lista con un argumento

	// inserta objeto Object al frente de la Lista
	public void insertarAlFrente(Object elementoInsertar) {
		if (estaVacia()) // primerNodo y ultimoNodo hacen referencia al mismo objeto
			primerNodo = ultimoNodo = new Nodo(elementoInsertar);
		else // primerNodo hace referencia al nuevo nodo
			primerNodo = new Nodo(elementoInsertar, primerNodo);
	} // fin del m�todo insertarAlFrente

	// inserta objeto Object al final del la Lista
	public void insertarAlFinal(Object elementoInsertar) {
		if (estaVacia()) // primerNodo y ultimoNodo hacen referencia al mismo objeto
			primerNodo = ultimoNodo = new Nodo(elementoInsertar);
		else // el siguienteNodo de ultimoNodo hace referencia al nuevo nodo
			ultimoNodo = ultimoNodo.siguienteNodo = new Nodo(elementoInsertar);
	} // fin del m�todo insertarAlFinal

	// elimina el primer nodo de la Lista
	public Object eliminarDelFrente() throws ExcepcionLista {
		if (estaVacia()) // lanza excepci�n si la Lista est� vac�a
			throw new ExcepcionLista(nombre);

		Object elementoEliminado = primerNodo.dato; // obtiene los datos que se van a eliminar

		// actualiza las referencias primerNodo y ultimoNodo
		if (primerNodo == ultimoNodo)
			primerNodo = ultimoNodo = null;
		else
			primerNodo = primerNodo.siguienteNodo;

		return elementoEliminado; // devuelve los datos del nodo eliminado
	}

	public Object eliminarDelFinal() throws ExcepcionLista {
		if (estaVacia()) // lanza excepci�n si la Lista est� vac�a
			throw new ExcepcionLista(nombre);

		Object elementoEliminado = ultimoNodo.dato; // obtiene los datos que se van a liminar

		// actualiza las referencias primerNodo y ultimoNodo
		if (primerNodo == ultimoNodo)
			primerNodo = ultimoNodo = null;
		else // localiza el nuevo �ltimo nodo
		{
			Nodo actual = primerNodo;

			// itera mientras el nodo actual no haga referencia a ultimoNodo
			while (actual.siguienteNodo != ultimoNodo)
				actual = actual.siguienteNodo;

			ultimoNodo = actual; // actual el nuevo ultimoNodo
			actual.siguienteNodo = null;
		} // fin de else

		return elementoEliminado; // devuelve los datos del nodo eliminado
	} // fin del m�todo eliminarDelFinal

	// determina si la lista est� vac�a
	public boolean estaVacia() {
		return primerNodo == null; // devuelve true si la lista est� vac�a
	} // fin del m�todo estaVacia

	// imprime el contenido de la lista
	public void imprimir() {
		if (estaVacia()) {
			System.out.printf("%s vacia\n", nombre);
			return;
		} // fin de if

		System.out.printf("La %s es: ", nombre);
		Nodo actual = primerNodo;

		// mientras no est� al final de la lista, imprime los datos del nodo actual
		while (actual != null) {
			System.out.printf("%s ", actual.dato);
			actual = actual.siguienteNodo;
		} // fin de while

		System.out.println("\n");
	} // fin del m�todo imprimir
}
