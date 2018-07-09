package pilarecursiva;

import EstructuraDatos.Nodo;
import EstructuraDatos.Pila;

public class Torre {
	Pila[] torrePila = new Pila[4];
	private int n;
	public Torre(int nro) {
		n = nro;
		torrePila[1] = new Pila();
		torrePila[2] = new Pila();
		torrePila[3] = new Pila();
	}
	void movimientoTorre(int disco, int a, int b, int c) {
		try {
		if (disco > 0) {
			movimientoTorre(disco - 1, a,  c,b);
			Nodo dato = torrePila[a].eliminar();
			int valor = (Integer) dato.ObtenerObjeto();
			torrePila[c].agregar(valor);
			mostrarTorre();
			movimientoTorre(disco - 1, b, a, c);}
		}catch(Exception e) {
			System.out.println("Error moviendo :" + e.getMessage());		}
	}
	public void llenarTorre() {
		for (int i = n; i > 0; i--)
			torrePila[1].agregar(i * 10);
		torrePila[1].imprimir();
		mostrarTorre();
		movimientoTorre(n , 1, 2, 3);
	}
	void mostrarTorre() {
		int t=0;
		if(torrePila[1].totalElemento()>torrePila[2].totalElemento() && torrePila[1].totalElemento()>torrePila[3].totalElemento())
			t=1;
		else if(torrePila[2].totalElemento()>torrePila[3].totalElemento() && torrePila[2].totalElemento()>torrePila[1].totalElemento()) {
			t=2;
		}else if(torrePila[3].totalElemento()>torrePila[2].totalElemento() && torrePila[3].totalElemento()>torrePila[1].totalElemento())
		{	t=3;			}
		else {t=1;}
		System.out.println("  A  |  B  |  C");
		System.out.println("---------------");
		while (torrePila[t].getNodoBase()!=null) {
			String d1 = " ", d2 = " ", d3 = " ";
			try {
				d1 = String.valueOf(torrePila[1].obtenerNodo());	} catch (Exception e) {
			}
			try {
				d2 = String.valueOf(torrePila[2].obtenerNodo());} catch (Exception e) {
			}
			try {
				d3 = String.valueOf(torrePila[3].obtenerNodo());} catch (Exception e) {
			}
			System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
		}
		torrePila[1].actualizarnodoBase();torrePila[2].actualizarnodoBase();	torrePila[3].actualizarnodoBase();
		System.out.println("\n");
	}
}
