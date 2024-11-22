package implementations;

import java.util.NoSuchElementException;
import appDomain.QueueADT;
import exceptions.EmptyQueueException;
import utilities.MyDLL;
import utilities.Iterator;

/**
 * Implementation of QueueADT using a doubly linked list.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueue<E> implements QueueADT<E> {
    
    private MyDLL<E> list;
    
    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        list = new MyDLL<>();
    }
    
    @Override
    public void enqueue(E element) {
        list.add(element);
    }
    
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from empty queue");
        }
        return list.remove(0);
    }
    
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot peek at empty queue");
        }
        return list.get(0);
    }
    
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public boolean isFull() {
        return false;  // LinkedList implementation is never full
    }
    
    @Override
    public void dequeueAll() {
        list.clear();
    }
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public boolean equals(QueueADT<E> that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }
        
        Iterator<E> thisIter = this.iterator();
        Iterator<E> thatIter = that.iterator();
        
        while (thisIter.hasNext()) {
            E thisElement = thisIter.next();
            E thatElement = thatIter.next();
            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray() {
        return (E[]) list.toArray();
    }
    
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        
        int size = size();
        if (array.length < size) {
            array = (E[]) java.lang.reflect.Array.newInstance(
                array.getClass().getComponentType(), size);
        }
        
        Iterator<E> iter = iterator();
        for (int i = 0; i < size; i++) {
            array[i] = iter.next();
        }
        
        if (array.length > size) {
            array[size] = null;
        }
        
        return array;
    }
    
    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * Checks if the queue contains a specific element.
     *
     * @param element the element to search for
     * @return true if the element is found, false otherwise
     * @throws NullPointerException if the element is null
     */
    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            if (element.equals(iter.next())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for an element in the queue and returns its position.
     * Position 1 is the front of the queue.
     *
     * @param element the element to search for
     * @return the position of the element (1-based), or -1 if not found
     */
    public int search(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        
        Iterator<E> iter = iterator();
        int position = 1;
        
        while (iter.hasNext()) {
            if (element.equals(iter.next())) {
                return position;
            }
            position++;
        }
        return -1;
    }
}
