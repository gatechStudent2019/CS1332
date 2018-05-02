/**
 * Your implementation of an array-backed stack.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class ArrayStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    public ArrayStack() {

    }

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
        T result;
        if (size == 0) {
            throw new java.util.NoSuchElementException("error: cannot pop from "
                + "an empty stack");
        } else {
            result = backingArray[size - 1];
            backingArray[size - 1] = null;
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
        } else if (size == backingArray.length) {
            T[] newBackingArray = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newBackingArray[i] = backingArray[i];
            }
            newBackingArray[size] = data;
            backingArray = newBackingArray;
            size++;
        } else {
            backingArray[size] = data;
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
        } else {
            return backingArray[size - 1];
        }
    }

    /**
     * Return true if this stack contains no elements, false otherwise.
     *
     * @return true if the stack is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    /**
     * Return the size of the stack.
     *
     * @return number of items in the stack
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the backing array of this stack.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }
}