package utilities;

import java.util.Arrays;
import java.util.Iterator;
import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {
    private E[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(E element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Cannot add null object to the list.");
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) throws NullPointerException, IndexOutOfBoundsException {
        if (element == null)
            throw new NullPointerException("Cannot add null object to the list");
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        return elements[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        E removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    @Override
    public boolean remove(E element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Cannot remove null element from the list.");
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public boolean contains(E element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Cannot search for null in the list.");
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new IndexOutOfBoundsException("No more elements in the list.");
                return elements[currentIndex++];
            }
        };
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("Cannot add null collection to the list");
        
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null)
            throw new NullPointerException("Cannot set null object in the list");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        
        E oldElement = elements[index];
        elements[index] = toChange;
        return oldElement;
    }
}
