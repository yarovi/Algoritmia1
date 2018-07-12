package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import EstructuraDatos.Cola;
import EstructuraDatos.ListaEnlazada;
import EstructuraDatos.Nodo;
import EstructuraDatos.Pila;
import pilarecursiva.Torre;

public class Menu {

	ListaEnlazada nuevaLista = new ListaEnlazada();
	Pila nuevaPila = new Pila();
	Cola nuevaCola = new Cola();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int opcion;

	public void probarListaRecursiva() {
		/*
		 * lista de numeros positivos
		 */

		// for (int i = 0; i < 5; i++) {
		// nuevaLista.agregar(i);
		// }
		// System.out.printf("\t\tLISTA SOLO NUMEROS POSITIVOS\n");
		// System.out.printf("Tamaño de la lista numerica [+]: %s\n",
		// nuevaLista.totalElemento());
		// nuevaLista.imprimir();
		/*
		 * lista dinamica ordenada de numeros positivos y negativos
		 */
		int[] vectorNumero = { 20, -2, 3, 5, 18, -9 };
		nuevaLista = new ListaEnlazada();
		for (int i = 0; i < vectorNumero.length; i++) {
			nuevaLista.agregar(vectorNumero[i]);
		}
		System.out.printf("\t\tLISTA SOLO NUMEROS POSITIVOS Y NEGATIVOS\n");
		nuevaLista.imprimir();
		System.out.printf("Tamaño de la lista de nombres [+-]: %s \n", nuevaLista.totalElemento());
		pedirValorABuscar();

	}

	public void probarListaRecursivaLetras() {
		/*
		 * llenando lista enlazada con valores de texto
		 */
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
		pedirValorABuscar();
	}

	public void probarPilaRecursiva() {

		int[] vectorNumero = { 20, -2, 3, 5, 18, -9 };
		for (int i = 0; i < vectorNumero.length; i++) {
			nuevaPila.agregar(vectorNumero[i]);
		}
		nuevaPila.imprimir();
		System.out.printf("largo de la lista numeros [+-]: %s \n", nuevaPila.totalElemento());

		pedirValorABuscar();
		nuevaPila.eliminarRecursiva();
		System.out.printf("largo de la Pila [+-]: %s \n", nuevaPila.totalElemento());
	}

	public void probarTorreHanoi() {

		int disco = getDato();
		if (disco > 0) {
			Torre torre = new Torre(disco);
			torre.llenarTorre();
		}
	}

	private int getDato() {
		Integer dato = 0;
		String entrada;
		boolean estado = false;
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

	public void probarCola() {

		int[] vectorNumero = { 20, -2, 3, 5, 18, -9 };
		for (int i = 0; i < vectorNumero.length; i++) {
			nuevaCola.encolar(vectorNumero[i]);
		}
		System.out.printf("largo de la colita [+-]: %s \n", nuevaCola.totalElemento());
		nuevaCola.imprimir();
		pedirValorABuscar();
		nuevaCola.desencolar();
		System.out.printf("largo de la colita [+-]: %s \n", nuevaCola.totalElemento());

	}

	public void pedirValorABuscar() {
		String entrada = "s";

		while (entrada.equals("s")) {
			try {
				System.out.print("Ingrese un valor a buscar:");
				entrada = br.readLine();
				int dato=0;
				Nodo nodoBuscado = null;
				switch (opcion) {
				case 1:
					dato = Integer.parseInt(entrada);
					nodoBuscado = nuevaLista.buscar(dato);
					break;
				case 2:
					nodoBuscado = nuevaLista.buscar(entrada);
				case 3:
					dato = Integer.parseInt(entrada);
					nodoBuscado = nuevaPila.buscar(dato);
					break;
				case 4:
					dato = Integer.parseInt(entrada);
					nodoBuscado = nuevaCola.buscar(dato);
					break;
				}

				if (nodoBuscado != null) {
					System.out.printf("Se encontro el nodo %s :)  \n", nodoBuscado.ObtenerObjeto());
				} else {
					System.out.printf("El nodo no existe %s \n", dato);

				}

				System.out.print("Desea buscar otro valor [s=SI,n=NO]:");
				entrada = br.readLine();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.printf("No se puede buscar ese valor \n", 3);
			}
		}

	}

	public void menuprincipal() {

		String entrada = "s";
		String salida = "";

		while (entrada.equals("s")) {
			salida = "\n\n" + "-----------------------------------------------------------------------------------\n"
					+ "\t\t\tMENU PRINCIPAL\n"
					+ "-------------------------------------------------------------------------------------\n"
					+ "1.- Usar Lista enlazada con numeros\n" + "2.- Usar Lista enlazada con Letras\n"
					+ "3.- Usar busqueda Recursiva en Pilas\n" + "4.- Usar busqueda Recursiva en Colas\n"
					+ "5.- Simulacion de Torre Hanoi\n" + "0.- salir\n";
			System.out.print(salida);
			try {
				System.out.println("Ingrese una opcion:");
				entrada = br.readLine();
				int opc = Integer.parseInt(entrada);
				switch (opc) {
				case 1:
					opcion = 1;
					probarListaRecursiva();
					break;
				case 2:
					opcion = 2;
					probarPilaRecursiva();
					break;
				case 3:
					opcion = 3;
					probarPilaRecursiva();
					break;
				case 4:
					opcion = 4;
					probarCola();
					break;
				case 5:
					probarTorreHanoi();
				case 0:
					break;
				}

				System.out.print("Ir al menu Principal : [s=SI,n=NO]:");
				entrada = br.readLine();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.printf("No se puede buscar ese valor \n", 3);
			}
		}
	}
}
