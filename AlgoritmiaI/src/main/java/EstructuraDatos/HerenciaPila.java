package EstructuraDatos;

public class HerenciaPila extends Lista{

	public HerenciaPila() {
		super("Pila");
	}
	public void poner(Object elementoNuevo) {
		insertarAlFrente(elementoNuevo);
	}
	public Object sacar() throws ExcepcionLista{
		return eliminarDelFrente();
	}
	public boolean estaVacia() {
		return estaVacia();
	}
}
