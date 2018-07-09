package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import EstructuraDatos.ListaEnlazada;
import EstructuraDatos.Nodo;
import EstructuraDatos.Pila;
import pilarecursiva.Torre;

public class Menu {

	
	

	public void probarListaRecursiva() {

		// numeros positivos
		ListaEnlazada nuevaLista = new ListaEnlazada();
		for (int i = 0; i < 5; i++) {
			nuevaLista.agregar(i);
		}
		System.out.printf("\t\tLISTA SOLO NUMEROS POSITIVOS\n");
		System.out.printf("Tamaño de la lista numerica [+]: %s\n", nuevaLista.totalElemento());
		nuevaLista.imprimir();

		// numeros positivos y megaticos
		int[] vectorNumero = { 20, -2, 3, 5, 18, -9 };
		nuevaLista = new ListaEnlazada();
		for (int i = 0; i < vectorNumero.length; i++) {
			nuevaLista.agregar(vectorNumero[i]);
		}
		System.out.printf("\t\tLISTA SOLO NUMEROS POSITIVOS Y NEGATIVOS\n");
		nuevaLista.imprimir();
		System.out.printf("Tamaño de la lista de nombres [+-]: %s \n", nuevaLista.totalElemento());

		// texto
		nuevaLista = new ListaEnlazada();
		String[] vectorNombres = { "carlos", "maria", "arnol", "bruno" };

		for (int i = 0; i < vectorNombres.length; i++) {
			nuevaLista.agregar(vectorNombres[i]);
		}
		System.out.printf("\t\tLISTA SOLO DE NOMBRES\n");
		nuevaLista.imprimir();
		System.out.printf("largo lista Nombres: %s\n", nuevaLista.totalElemento());
		// ejemplo de busqueda
		Nodo nodoResultado = nuevaLista.buscar("maria");
		System.out.println("Elementos encontrados :" + nodoResultado.ObtenerObjeto());
		nodoResultado = nuevaLista.eliminar("carlos");
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nuevaLista.imprimir();

	}

	public void probarPilaRecursiva() {
		Pila nuevaPila = new Pila();
		int[] vectorNumero = { 20, -2, 3, 5, 18, -9 };
		for (int i = 0; i < vectorNumero.length; i++) {
			nuevaPila.agregar(vectorNumero[i]);
		}
		nuevaPila.imprimir();
		System.out.printf("largo de la lista numeros [+-]: %s \n", nuevaPila.totalElemento());
		Nodo nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nuevaPila.imprimir();
		nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nuevaPila.imprimir();
		System.out.printf("largo de la lista de Nombres [+-]: %s \n", nuevaPila.totalElemento());
		nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		nodoResultado = nuevaPila.eliminar();
		System.out.println("nombre eliminado :" + nodoResultado.ObtenerObjeto());
		System.out.printf("largo lista numero [+-]: %s \n", nuevaPila.totalElemento());
		nuevaPila.imprimir();
	}
	
	public void probarTorreHanoi() {
		
		int disco=getDato();
		if(disco>0) {
			Torre torre=new Torre(disco);
			torre.llenarTorre();			
		}		
	}
	BufferedReader br;
	private int getDato()
	{
		Integer dato = 0;
		String entrada;
		boolean estado = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		while (estado == false) {
			try {
				System.out.print("Ingrese cantidad Discos:");
				entrada = br.readLine();
				estado = IsNumeric(entrada);
				if (estado) {
					dato = Integer.parseInt(entrada);
				} else {
					System.out.print("No es valido intentelo de nuevo:");
				}
			} catch (Exception e) {
			}
		}
		return dato;		
	}
	private boolean IsNumeric(String dato) {

		try {
			Integer.parseInt(dato);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
