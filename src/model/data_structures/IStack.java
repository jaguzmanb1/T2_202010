package model.data_structures;


public interface IStack<T> extends Iterable<T>{
	
public boolean isEmpty();
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size();
	
	/**
	 * Inserta un nuevo elemento en la Pila
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void push(T t);
	
	/**
	 * Quita y retorna el elemento agregado m�s recientemente
	 * @return el elemento agregado m�s recientemente
	 */
	public T pop();	
}
