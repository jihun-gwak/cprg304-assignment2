package appDomain;

import utilities.Iterator;

/**
 * QueueADT interface represents a generic queue abstract data type.
 *
 * @param <E> the type of elements held in this queue
 */
public interface QueueADT<E> {
    
    /**  
     * Adds one element to the rear of this queue. 
     * 
     * @param element the element to be added to the rear of this queue
     */
    void enqueue(E element);

    /**  
     * Removes and returns the element at the front of this queue.
     * 
     * @return the element at the front of this queue
     */
    E dequeue();

    /**  
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    E peek();

    /**  
     * Returns true if this queue contains no elements.
     * 
     * @return true if this queue is empty
     */
    boolean isEmpty();
    
    /**
     * Returns true if this queue is at full capacity.
     * 
     * @return true if this queue is full
     */
    boolean isFull();

    /**
     * Removes all elements from this queue, making it empty.
     */
    void dequeueAll();

    /**  
     * Returns the number of elements in this queue. 
     * 
     * @return the integer representation of the size of this queue
     */
    int size();

    /**
     * Checks if this queue is equal to another queue by comparing
     * elements in the same order.
     *
     * @param that another QueueADT instance to compare with
     * @return true if both queues contain the same elements in the same order
     */
    boolean equals(QueueADT<E> that);

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * Note: The iterator's remove() method is unsupported.
     *
     * @return an iterator over the elements in this queue
     */
    Iterator<E> iterator();

    /**
     * Returns an array containing all of the elements in this queue in proper sequence.
     *
     * @return an array containing the elements of this queue
     */
    E[] toArray();

    /**
     * Returns an array containing all of the elements in this queue in proper sequence;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param holder the array into which the elements of this queue are to be stored
     * @return an array containing the elements of this queue
     * @throws NullPointerException if the specified array is null
     */
    E[] toArray(E[] holder) throws NullPointerException;

    /**
     * Returns true if this queue contains the specified element.
     * More formally, returns true if and only if this queue contains
     * at least one element e such that obj.equals(e).
     *
     * @param obj element whose presence in this queue is to be tested
     * @return true if this queue contains the specified element
     */
    boolean contains(Object obj);

    /**
     * Searches for the specified element in the queue and returns its index.
     * Returns -1 if the element is not found.
     *
     * @param obj element to search for
     * @return the index of the first occurrence of the element in this queue,
     *         or -1 if this queue does not contain the element
     * @throws NullPointerException if the specified element is null
     */
    int search(Object obj) throws NullPointerException;

    /**  
     * Returns a string representation of this queue. 
     *
     * @return the string representation of this queue
     */
    @Override
    String toString();
}
