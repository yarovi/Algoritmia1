package EstructuraDatos;

public class ListaEnlazada {

	Nodo nodo;
	int largo;	
	public boolean agregar(Object ele) {
		
		boolean agrego=false;
		Nodo nodoBuscado=buscar(ele);
		Nodo nuevoNodo=new Nodo(ele);
		if(nodoBuscado==null) {
			if(nodo==null) {
				nodo=nuevoNodo;
				largo++;				
			}else {				
				if(nodo.comparador(nodo.ObtenerObjeto(), ele)>0) {
					nuevoNodo.setSiguienteNodo(nodo);
					nodo=nuevoNodo;
					nuevoNodo.getSiguienteNodo().setAnteriorNodo(nuevoNodo);
					largo++;					
				}else {
					agrego=nodo.agregar(ele);
					if(agrego==true)
						largo++;
				}				
			}				
		}		
		return agrego;		
	}	
	public Nodo buscar(Object ele) {
		
		Nodo rpta =null;
		if(nodo!=null)	{
			rpta=nodo.buscar(ele);	}
		return rpta;
	}	
	public Nodo eliminar(Object ele) {		
		Nodo eliminado=buscar(ele);		
		if(eliminado!=null) {
			eliminado.getAnteriorNodo().setSiguienteNodo(eliminado.getSiguienteNodo());
			eliminado.siguienteNodo.setAnteriorNodo(eliminado.getAnteriorNodo());			
		}
		return eliminado;
	}
	public int totalElemento(){
		return largo;}
	
	public void imprimir() {
		Nodo actualNodo = nodo;
		int i=largo;
		while (actualNodo != null) {
			i--;
			if (actualNodo.getSiguienteNodo() != null)
				System.out.printf("{%s,[%s]} -->",i, actualNodo.dato);
			else
				System.out.printf("{%s, [%s]}",i, actualNodo.dato);
			actualNodo = actualNodo.siguienteNodo;
		}
		System.out.println("\n");
	}	
	public boolean estaVacia() {
		return nodo == null;
	}	
	public Nodo obtenerElemetno() {
		return nodo;
	}
}
