package implementations;

import java.util.NoSuchElementException;
import appDomain.QueueADT;
import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.MyDLL;

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
    public void enqueue(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        list.add(element);
    }
   
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from empty queue");
        }
        return list.remove(0);
    }
   
    @Override
    public E peek() throws EmptyQueueException {
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
        return false;  // DLL-based implementation is never full
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
       
        Iterator<E> thisIt = this.iterator();
        Iterator<E> thatIt = that.iterator();
       
        while (thisIt.hasNext() && thatIt.hasNext()) {
            E thisElement = thisIt.next();
            E thatElement = thatIt.next();
            
            if (thisElement == null ? thatElement != null : !thisElement.equals(thatElement)) {
                return false;
            }
        }
        return true;
    }
   
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
   
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
   
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException();
        }
        
        if (holder.length < size()) {
            holder = (E[]) java.lang.reflect.Array.newInstance(
                holder.getClass().getComponentType(), size());
        }
        
        int i = 0;
        for (E element : this) {
            holder[i++] = element;
        }
        
        if (holder.length > size()) {
            holder[size()] = null;
        }
        
        return holder;
    }
   
    public String toString() {
        return list.toString();
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
            return -1;
        }
        
        int position = 1;
        for (E e : this) {
            if (element.equals(e)) {
                return position;
            }
            position++;
        }
        return -1;
    }
   
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }
}
