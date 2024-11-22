package utilities;

import java.util.NoSuchElementException;
import implementations.MyDLLNode;

/**
 * Implementation of a doubly linked list.
 *
 * @param <E> the type of elements in this list
 */
public class MyDLL<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;
    
    /**
     * Constructs an empty list.
     */
    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    public void add(E element) {
        MyDLLNode<E> newNode = new MyDLLNode<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Removes and returns the element at the specified position.
     *
     * @param index the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        MyDLLNode<E> current;
        if (index == 0) {
            current = head;
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            current = getNode(index);
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        size--;
        return current.getElement();
    }
    
    /**
     * Returns the element at the specified position.
     *
     * @param index the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).getElement();
    }
    
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Removes all elements from this list.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    public utilities.Iterator<E> iterator() {
        return new utilities.Iterator<E>() {
            private MyDLLNode<E> current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }
            
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }
    
    /**
     * Returns an array containing all of the elements in this list.
     *
     * @return an array containing all of the elements in this list
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.getElement();
            current = current.getNext();
        }
        return result;
    }
    
    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        MyDLLNode<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.append("]").toString();
    }
    
    /**
     * Returns the node at the specified index.
     *
     * @param index the index of the node to return
     * @return the node at the specified index
     */
    private MyDLLNode<E> getNode(int index) {
        MyDLLNode<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }
}
