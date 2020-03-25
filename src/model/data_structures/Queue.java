package model.data_structures;

import java.util.Iterator;

public class Queue<T> implements IQueue<T>{
	
	protected NodeCola<T> primero;
	
	protected NodeCola<T> ultimo;

	protected int numElems;

	public Queue( ){
		primero = null;
		ultimo = null;
		numElems = 0;
	}
	
	public int size( ){
		return numElems;
	}
	
	@Override
	public T dequeue( )
	{
		NodeCola<T> p = primero;
		primero = primero.desconectarPrimero( );
		if( primero == null )
			ultimo = null;
		numElems--;
		return p.darElemento( );

	}
	
	@Override
	public boolean isEmpty() {
		if (numElems == 0)
			return true;
		return false;
	}
	
	@Override
	public void enqueue(T elemento) {
		NodeCola<T> nodo = new NodeCola<T>( elemento );
		if( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else{
			ultimo = ultimo.insertarDespues( nodo );
		}
		numElems++;
	}
	
	public NodeCola<T> darPrimerElemento( ){
		return primero;
	}
	
	public void vaciar( ){
		numElems = 0;
		primero = null;
		ultimo = null;
	}
	
	public NodeCola<T> darUltimoElemento( ){
		return ultimo;
	}
	
	public void reemplazarCola(Queue<T> cola) {
		vaciar();
		int size = cola.size();
		for (int i = 0 ; i < size ; i++) {
			enqueue(cola.dequeue());
		}
	}
	
}
