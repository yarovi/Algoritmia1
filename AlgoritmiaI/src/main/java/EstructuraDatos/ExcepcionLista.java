package EstructuraDatos;

public class ExcepcionLista extends RuntimeException {

	public ExcepcionLista() {
		this("Lista");
	}
	
	public ExcepcionLista(String x_nombre) {
		super(x_nombre +"esta vacia" );
		System.out.println("fallo\n" + x_nombre);
	}


	
}
