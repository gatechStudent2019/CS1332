/**
 * Your implementation of an ArrayList.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class ArrayList<T> implements ArrayListInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * You may add statements to this method.
     */
    public ArrayList() {
        backingArray = (T[]) (new Object[INITIAL_CAPACITY]);
    }

    @Override
    public void addAtIndex(int index, T data) throws IllegalArgumentException,
        IndexOutOfBoundsException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, index is negative or "
               + "larger than size of ArrayList");
        }

        if (size == backingArray.length - 1) {
            T[] tempArray = (T[]) (new Object[backingArray.length * 2]);
            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
        }

        size++;

        for (int i = size; i >= index; i--) {
                if (i == 0) {
                    backingArray[i] = data;
                } else {
                    backingArray[i] = backingArray[i - 1];
                }
            }

            backingArray[index] = data;

    }

    @Override
    public void addToFront(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        if (size >= backingArray.length) {
            T[] tempArray = (T[]) (new Object[backingArray.length * 2]);
            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
        }

        for (int i = size; i > 0; i--) {
            backingArray[i] = backingArray[i - 1];
        }

        backingArray[0] = data;
        size++;
    }

    @Override
    public void addToBack(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        if (size >= backingArray.length) {
            T[] tempArray = (T[]) (new Object[backingArray.length * 2]);
            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
        }

        backingArray[size] = data;
        size++;
    }

    @Override
    public T removeAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, index is negative or "
               + "larger than size of ArrayList");
        }

        T result = backingArray[index];

        for (int i = index; i < size; i++) {
            backingArray[i] = backingArray[i + 1];
        }

        size--;
        return result;
    }

    @Override
    public T removeFromFront() {
        T result;
        result = backingArray[0];

        for (int i = 0; i < size; i++) {
            backingArray[i] = backingArray[i + 1];
        }

        size--;

        return result;
    }

    @Override
    public T removeFromBack() {
        T result;
        result = backingArray[size - 1];

        backingArray[size - 1] = null;

        size--;

        return result;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, index is negative or "
               + "larger than size of ArrayList");
        }

        return backingArray[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        backingArray = (T[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
    }

    @Override
    public Object[] getBackingArray() {
        // DO NOT MODIFY.
        return backingArray;
    }
}