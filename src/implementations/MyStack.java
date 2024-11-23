package implementations;

import java.util.EmptyStackException;

import utilities.Iterator;
import utilities.MyDLL;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
	
	private MyDLL<E> list;
	
	public MyStack() {
		list = new MyDLL<E>();
	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException("toAdd is null, and should not be");
		} else {
			list.add(0, toAdd);
		}
		
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (list.size() <= 0) {
			throw new EmptyStackException();
		} else {
			E popped = list.get(0);
			list.remove(0);
			return popped;
		}
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (list.size() <= 0) {
			throw new EmptyStackException();
		} else {
			return list.get(0);
		}
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean isEmpty() {
		return list.size() <= 0;
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
			throw new NullPointerException("holder must not be null");
		} else {
			return list.toArray(holder);
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException("toFind must not be null");
		} else {
			return list.contains(toFind);
		}
	}

	@Override
	public int search(E toFind) {
		for (int i = 0; i < list.size(); i++) {
			if (toFind.equals(list.get(i))) {
				return i + 1;
			}
		}
		
		return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public boolean equals(StackADT<E> that) {
		E[] thatArray = (E[]) that.toArray();
		E[] thisArray = (E[]) this.toArray();
		
		for (int i = 0; i < list.size(); i++) {
			if (!thatArray[i].equals(thisArray[i])) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean stackOverflow() {
		E[] array = (E[]) this.toArray();
		return array.length == this.size();
	}
    
}
