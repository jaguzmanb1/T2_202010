package model.data_structures;


public interface IStack<T>{
	
	public int size();
	
	public void push(T t);
	
	public T pop();

	boolean isEmpty();	
}
