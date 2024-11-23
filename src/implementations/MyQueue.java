package implementations;
<<<<<<< HEAD

import java.util.NoSuchElementException;
import appDomain.QueueADT;
import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.MyDLL;
import java.util.Arrays;

public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> list;
    
    public MyQueue() {
        list = new MyDLL<>();
    }
    
    @Override
    public void enqueue(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        list.add(element);
    }
    
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.remove(0);
    }
    
    @Override
    public void dequeueAll() {
        list.clear();
    }
    
    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.get(0);
    }
    
=======
 
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
   
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
<<<<<<< HEAD
    
    @Override
    public boolean isFull() {
        return false;  // DLL-based implementation is never full
    }
    
=======
   
    @Override
    public boolean isFull() {
        return false;  // LinkedList implementation is never full
    }
   
    @Override
    public void dequeueAll() {
        list.clear();
    }
   
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
    @Override
    public int size() {
        return list.size();
    }
<<<<<<< HEAD
    
=======
   
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
    @Override
    public boolean equals(QueueADT<E> that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }
<<<<<<< HEAD
        
        Iterator<E> thisIt = this.iterator();
        Iterator<E> thatIt = that.iterator();
        
        while (thisIt.hasNext() && thatIt.hasNext()) {
            E thisElement = thisIt.next();
            E thatElement = thatIt.next();
=======
       
        utilities.Iterator<E> thisIter = this.iterator();
        utilities.Iterator<E> thatIter = that.iterator();
       
        while (thisIter.hasNext()) {
            E thisElement = thisIter.next();
            E thatElement = thatIter.next();
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }
<<<<<<< HEAD
        
        return true;
    }
    
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
    
    @Override
    public E[] toArray() {
        Object[] array = list.toArray();
        try {
            E[] typedArray = (E[]) java.lang.reflect.Array.newInstance(
                array.getClass().getComponentType(), array.length);
            System.arraycopy(array, 0, typedArray, 0, array.length);
            return typedArray;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unable to create array of the proper type", e);
        }
    }
    
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }
    
    @Override
    public boolean contains(Object obj) {
    // Your existing implementation
    Iterator<E> iterator = iterator();
    while (iterator.hasNext()) {
        E element = iterator.next();
        if (element.equals(obj)) {
            return true;
        }
    }
    return false;
}
    
    @Override
    public int search(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        
        try {
            Iterator<E> it = iterator();
            int index = 0;
            
            while (it.hasNext()) {
                E element = it.next();
                if (obj.equals(element)) {
                    return index;
                }
                index++;
            }
        } catch (ClassCastException e) {
            return -1;
        }
        
        return -1;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> it = iterator();
        sb.append("[");
        
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}
=======
        return true;
    }
   
    @Override
    public utilities.Iterator<E> iterator() {
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
       
        utilities.Iterator<E> iter = iterator();
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
       
        utilities.Iterator<E> iter = iterator();
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
       
        utilities.Iterator<E> iter = iterator();
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
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
