package model.data_structures;

import java.util.*;

//import com.sun.tools.classfile.Annotation.element_value;

//import sun.net.www.content.text.plain;

public class Stack<T> implements IStack<T> {
	
	private NodoStack<T> primerElemeto;
	
	private int numeroElementos;
	
	public Stack()
	{
		
		primerElemeto = null;
		numeroElementos = 0;
		
	}
	
	@Override
	public boolean isEmpty() {
		if (numeroElementos == 0)
			return true;
		return false;
	}
	
	public T pop() 
	{
		NodoStack<T> primerElementoAEliminar = primerElemeto;
		primerElemeto = primerElemeto.eliminarPrimerElemento();
		numeroElementos--;
		return primerElementoAEliminar.darElemento();
	}
	
	public void push( T pElemeto) 
	{
		NodoStack<T> nuevoNodo = new NodoStack<T>(pElemeto);
		if ( primerElemeto == null) 
		{
			primerElemeto = nuevoNodo;
		}
		else 
		{
			primerElemeto = primerElemeto.insertarElementoAntesDelActual(nuevoNodo);
		}
		numeroElementos++;
	}
	
	public NodoStack<T> darPrimero() 
	{
		return primerElemeto;
	}
	
	public boolean stackEstaVacio() 
	{
		if (primerElemeto == null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public int size() {
		return numeroElementos;
	}

}
