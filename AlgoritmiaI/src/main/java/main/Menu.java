package main;

import EstructuraDatos.ExcepcionLista;
import EstructuraDatos.HerenciaPila;
import EstructuraDatos.Lista;
import EstructuraDatos.ListaEnlazada;
import EstructuraDatos.Nodo;
import EstructuraDatos.Pila;

public class Menu {

	public void probarPila() {

		HerenciaPila nuevaPila =new HerenciaPila();
		nuevaPila.poner(500);
		nuevaPila.imprimir();
		nuevaPila.poner("Maria");
		nuevaPila.imprimir();
		nuevaPila.poner(600);
		nuevaPila.imprimir();
		nuevaPila.poner("Jose");
		nuevaPila.imprimir();

		// elimina elementos de la pila
		try {
			Object objetoEliminado = null;

			while (true) {
				objetoEliminado = nuevaPila.sacar(); // usa el método sacar (pop)
				/*if(objetoEliminado==null)
					break;*/
				System.out.printf("Se saco %s\n", objetoEliminado);
				nuevaPila.imprimir();
			} 
		} 
		catch (ExcepcionLista excepcionLista) {
			excepcionLista.printStackTrace();
			System.out.println("Fallo en  :"+excepcionLista.getMessage());
		} 
	}

	public void probarLista() {

try {
			
			Lista nuevaLista = new Lista();
			// inserta enteros en lista
			nuevaLista.insertarAlFrente(-1);
			nuevaLista.imprimir();
			nuevaLista.insertarAlFrente(0);
			nuevaLista.imprimir();
			nuevaLista.insertarAlFinal(1);
			nuevaLista.imprimir();
			nuevaLista.insertarAlFinal(5);
			nuevaLista.imprimir();
			Object objetoEliminado = nuevaLista.eliminarDelFrente();
			System.out.printf("%s eliminado\n", objetoEliminado);
			nuevaLista.imprimir();

			objetoEliminado = nuevaLista.eliminarDelFrente();
			System.out.printf("%s eliminado\n", objetoEliminado);
			nuevaLista.imprimir();

			objetoEliminado = nuevaLista.eliminarDelFinal();
			System.out.printf("%s eliminado\n", objetoEliminado);
			nuevaLista.imprimir();

			objetoEliminado = nuevaLista.eliminarDelFinal();
			System.out.printf("%s eliminado\n", objetoEliminado);
			nuevaLista.imprimir();
		} // fin de try
		catch (ExcepcionLista excepcionListaVacia) {
			System.out.println("error : "+excepcionListaVacia.getMessage());
			excepcionListaVacia.printStackTrace();
			
		}
	}
	
	public void probarLista2() {
		
		//numeros positivos
		ListaEnlazada nuevaLista = new ListaEnlazada();
		for(int i=0; i<5;i++) {
				nuevaLista.agregar(i);
		}
		System.out.printf("largo lista numero [+]: %s\n", nuevaLista.totalElemento());
		nuevaLista.imprimir();
		
		//numeros positivos y megaticos
		int [] vectorNumero= {20,-2,3,5,18,-9};
		nuevaLista = new ListaEnlazada();
		for(int i=0;i<vectorNumero.length;i++) {
			nuevaLista.agregar(vectorNumero[i]);
		}
		nuevaLista.imprimir();
		System.out.printf("largo lista numero [+-]: %s \n", nuevaLista.totalElemento());
		
		//texto
		nuevaLista = new ListaEnlazada();
		String [] vectorNombres= {"carlos","maria","arnol","bruno"};
		
		for(int i=0;i<vectorNombres.length;i++) {
			nuevaLista.agregar(vectorNombres[i]);
		}
		nuevaLista.imprimir();
		System.out.printf("largo lista Nombres: %s\n", nuevaLista.totalElemento());
		//ejemplo de busqueda
		Nodo nodoResultado=nuevaLista.buscar("maria");
		System.out.println("Elementos encontrados :" + nodoResultado.ObtenerObjeto());
		nodoResultado=nuevaLista.eliminar("carlos");
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nuevaLista.imprimir();
		
	}
	public void pruebaPila()
	{
		Pila nuevaPila=new Pila();
		int [] vectorNumero= {20,-2,3,5,18,-9};
		for(int i=0;i<vectorNumero.length;i++) {
			nuevaPila.agregar(vectorNumero[i]);
		}
		nuevaPila.imprimir();
		System.out.printf("largo lista numero [+-]: %s \n", nuevaPila.totalElemento());
		
	}
}
