package utilities;

import implementations.MyDLLNode;
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head, tail; 
    private int size;

    public MyDLL() {
        this.head = this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E element) throws NullPointerException, IndexOutOfBoundsException {
        if (element == null) throw new NullPointerException("Element cannot be null.");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index.");

        MyDLLNode<E> newNode = new MyDLLNode<>(element);

        if (index == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
        } else if (index == size) { 
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else { 
            MyDLLNode<E> current = getNodeAt(index);
            MyDLLNode<E> prevNode = current.getPrev();
            prevNode.setNext(newNode);
            newNode.setPrev(prevNode);
            newNode.setNext(current);
            current.setPrev(newNode);
        }
        
        size++;
        
        
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd); 
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("List to add cannot be null");

        utilities.Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(size, iterator.next());
        }
        
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return getNodeAt(index).getElement();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index.");

        MyDLLNode<E> current = getNodeAt(index);
        if (current == head) {
            head = head.getNext();
            if (head != null) head.setPrev(null);
        } else if (current == tail) {
            tail = tail.getPrev();
            if (tail != null) tail.setNext(null);
        } else {
            MyDLLNode<E> prevNode = current.getPrev();
            MyDLLNode<E> nextNode = current.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }

        size--;
        
        
        if (size == 0) {
            head = tail = null;
        }

        return current.getElement();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException("Element to remove cannot be null.");

        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getElement().equals(toRemove)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) head.setPrev(null);
                } else if (current == tail) {
                    tail = tail.getPrev();
                    if (tail != null) tail.setNext(null);
                } else {
                    MyDLLNode<E> prevNode = current.getPrev();
                    MyDLLNode<E> nextNode = current.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                }
                size--;
                return current.getElement();
            }
            current = current.getNext();
        }

        return null; 
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException("Element to change cannot be null.");
        MyDLLNode<E> current = getNodeAt(index);
        E oldValue = current.getElement();
        current.setElement(toChange);
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException("Element to find cannot be null.");

        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getElement().equals(toFind)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException("Array to hold elements cannot be null.");
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }

        int i = 0;
        MyDLLNode<E> current = head;
        while (current != null) {
            toHold[i++] = current.getElement();
            current = current.getNext();
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        MyDLLNode<E> current = head;
        
        while (current != null) {
        	
            array[i++] = current.getElement();
            current = current.getNext();
            
        }
        
        return array;
    }

    @Override
    public utilities.Iterator<E> iterator() {
        return new DLLIterator();
    }

    private MyDLLNode<E> getNodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index.");

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


    private class DLLIterator implements utilities.Iterator<E> {
        private MyDLLNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E data = current.getElement();
            current = current.getNext();
            return data;
        }
    }
}
