package model.data_structures;

import model.data_structures.Node;

public class LinkedList <T extends Comparable <T>> implements ILinkedList<T>{

	private Node<T> primero;

	private Node<T> ultimo;

	private int numElems;

	public LinkedList( ){
		primero = null;
		ultimo = null;
		numElems = 0;
	}

	public Node<T> darUltimo( ){
		return ultimo;
	}

	public Node<T> darPrimero( ){
		return primero;
	}

	@Override
	public int size( ){
		return numElems;
	}

	public T buscar( T modelo ){
		for ( Node<T> p = primero ; p != null ; p = p.darSiguiente( ) ){
			if ( p.darElemento( ).equals( modelo ) ){
				return p.darElemento( );
			}
		}
		return null;
	}
	
	public String buscarPorId(T modelo){
		for ( Node<T> p = primero ; p != null ; p = p.darSiguiente( ) ){
			if ( p.darElemento().compareTo(modelo) == 0 ){
				return p.darElemento( ).toString();
			}
		}
		return null;
	}

	@Override
	public void insertarAlFrente( T elemento ){
		Node<T> nodo = new Node<T>( elemento );
		if ( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else {
			primero.insertarAntes( nodo );
			primero = nodo;
		}
		numElems++;
	}

	@Override
	public void insertarAlFinal( T elemento )
	{
		Node<T> nodo = new Node<T>( elemento );
		if ( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else {
			ultimo.insertarDespues( nodo );
			ultimo = nodo;
		}
		numElems++;
	}

	public T eliminarNodo( Node<T> nodo ){
		T r = null;
		if( buscar(nodo.darElemento( )) != null ){
			return null;
		}
		if( primero == nodo ){
			r = primero.darElemento();
			primero = nodo.popPrimero( );

			if( ultimo == nodo ){
				ultimo = null;
			}
		}
		else if (ultimo == nodo ){
			ultimo = nodo.darAnterior( );
			r = ultimo.darElemento();
			nodo.desconectarNodo( );
		}
		return r;
	}

	public T eliminarUltimo( ){
		if ( ultimo == null ){
			return null;
		}
		else {
			T r = ultimo.darElemento();
			eliminarNodo(ultimo);
			numElems--;
			return r;
		}
	}

	@Override
	public boolean isEmpty() {
		if (numElems == 0)
			return true;
		return false;
	}
	
}
