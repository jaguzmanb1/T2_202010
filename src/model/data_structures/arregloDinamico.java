package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {

	private int tamanoMax;

	private int tamanoAct;

	private T elementos[ ];

	@SuppressWarnings("unchecked")
	public ArregloDinamico( int max )
	{
		elementos = (T[])new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++){
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		return elementos[i];
	}

	public T buscar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.

		for (int i = 0 ; i < elementos.length ; i ++ ) {
			if (elementos[i] != null){
				if (dato.compareTo(elementos[i]) == 0) {
					return elementos[i];
				}
			}
		}

		return null;
	}
	
	public boolean existe(T dato){
		if (buscar(dato) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public T eliminar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T datoEliminar = null;
		int lenght = elementos.length;
		boolean change = false;

		for (int i = 0 ; i < elementos.length && change == false ; i ++ ) {
			if (dato.compareTo(elementos[i]) == 0) {
				datoEliminar = elementos[i];
				System.arraycopy(elementos, i + 1, elementos, i, lenght - (i+1));
				tamanoAct = tamanoAct - 1;
				change = true;
			}
		}

		return datoEliminar;
	}
	
	public void vaciar(int max) {
		elementos = (T[])new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;	
	}

}
