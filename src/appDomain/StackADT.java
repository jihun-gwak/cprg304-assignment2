package appDomain;

import utilities.Iterator;

/**
 * StackADT interface represents a generic stack abstract data type.
 * A stack is a last in, first out data structure.
 * 
 * 
 * @param <E> the type of elements held in this data structure.
 */
public interface StackADT<E> {
	
	/**
	 * Checks the size of the stack.
	 * @return Returns the size of the stack as an integer.
	 */
	public int size();
	
	/**
	 * Clears all items from the stack.
	 */
	public void clear();
	
	/**
	 * Checks if the stack contains a value
	 * @param element The element to search the stack for.
	 * @return Returns <code>true</code> if the stack contains the element.
	 */
	public boolean contains(E element);
	
	/**
	 * Check if a stack is equal to another stack.
	 * @param that the other stack to compare to.
	 * @return Returns <code>true</code> if both stacks are equal.
	 */
	public boolean equals(StackADT<E> that);
	
	/**
	 * Finds the position of an element within the stack.
	 * @param element The element to find the position of.
	 * @return The position of the element given.
	 */
	public int search(E element);
	
	/** 
	 * Pushes an element to the top of the stack.
	 * @param element The element that is being added to the top of the stack.
	 */
	public void push(E element);
	
	/**
	 * Pops the top element off of the stack.
	 * 
	 * @return Returns the element popped off the top of the stack.
	 */
	public E pop();
	
	/**
	 * Returns the top element of the stack
	 * @return The top element of the stack.
	 */
	public E peek();
	
	/**
	 * Checks if the stack is empty
	 * @return Returns <code>true</code> if the stack is empty.
	 */
	public boolean isEmpty();
	
	/**
     * Returns an iterator over the elements in this stack from top to bottom.
     * Note: The iterator's remove() method is unsupported.
     *
     * @return an iterator over the elements in this stack
     */
	public Iterator<E> iterator();
	
	/**
     * Returns an array containing all of the elements in this stack in top to bottom order.
     *
     * @param copy an array into which the elements of this stack are to be stored
     * @return an array containing the elements of this stack
     */
	public E[] toArray();
	
	/**
	 * Returns a string representation of the stack.
	 * @return
	 */
	@Override
	String toString();
}
