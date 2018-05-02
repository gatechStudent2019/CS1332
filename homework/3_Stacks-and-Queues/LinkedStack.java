/**
 * Your implementation of a linked stack. It should NOT be circular.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private int size;

    /**
     * Pop from the stack.
     *
     * Removes and returns the top-most element on the stack.
     *
     * @return the data from the front of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() {
        T result = null;
        if (size == 0) {
            throw new java.util.NoSuchElementException("error: cannot pop from "
                + "an empty stack");
        } else if (size == 1) {
            result = head.getData();
            head = null;
            size--;
        } else {
            result = head.getData();
            LinkedNode<T> next = head.getNext();
            head.setNext(null);
            head = next;
            size--;
        }
        return result;
    }

    /**
     * Push the given data onto the stack.
     *
     * The given element becomes the top-most element of the stack.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot push null data");
        } else if (size == 0) {
            head = new LinkedNode<>(data);
            size++;
        } else {
            LinkedNode<T> newHead = new LinkedNode<>(data);
            newHead.setNext(head);
            head = newHead;
            size++;
        }
    }

    /**
     * Retrieves the next data to be popped without removing it.
     *
     * @return the next data or null if the stack is empty
     */
    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the head of this stack.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }
}