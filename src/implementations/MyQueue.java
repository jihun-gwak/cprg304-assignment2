package implementations;

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
    
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public boolean isFull() {
        return false;  // DLL-based implementation is never full
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
    
    @Override
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
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
