package implementations;
 
/**
 * Node class for doubly linked list implementation.
 *
 * @param <E> the type of element stored in this node
 */
public class MyDLLNode<E> {
    private E element;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;
   
    /**
     * Constructs a new node with the given element.
     *
     * @param element the element to store in this node
     */
    public MyDLLNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
   
    /**
     * Gets the element stored in this node.
     *
     * @return the element stored in this node
     */
    public E getElement() {
        return element;
    }
   
    /**
     * Sets the element stored in this node.
     *
     * @param element the new element to store
     */
    public void setElement(E element) {
        this.element = element;
    }
   
    /**
     * Gets the next node in the list.
     *
     * @return the next node
     */
    public MyDLLNode<E> getNext() {
        return next;
    }
   
    /**
     * Sets the next node in the list.
     *
     * @param next the new next node
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
   
    /**
     * Gets the previous node in the list.
     *
     * @return the previous node
     */
    public MyDLLNode<E> getPrev() {
        return prev;
    }
   
    /**
     * Sets the previous node in the list.
     *
     * @param prev the new previous node
     */
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}