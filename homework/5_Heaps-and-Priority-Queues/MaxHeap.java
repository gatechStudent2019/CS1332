import java.util.ArrayList;
/**
 * Your implementation of a max heap.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class MaxHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a Heap with an initial capacity of {@code INITIAL_CAPACITY}
     * for the backing array.
     *
     * Use the constant field in the interface. Do not use magic numbers!
     */
    public MaxHeap() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Creates a properly ordered heap from a set of initial values.
     *
     * You must use the Build Heap algorithm that was taught in lecture! Simply
     * adding the data one by one using the add method will not get any credit.
     *
     * The initial array before the Build Heap algorithm takes place should
     * contain the data in the same order as it appears in the ArrayList.
     *
     * The {@code backingArray} should have capacity 2n + 1 where n is the
     * number of data in the passed in ArrayList (not INITIAL_CAPACITY from
     * the interface). Index 0 should remain empty, indices 1 to n should
     * contain the data in proper order, and the rest of the indices should
     * be empty.
     *
     * @param data a list of data to initialize the heap with
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public MaxHeap(ArrayList<T> data) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException("error: data is null");
        }
        size = data.size();
        backingArray = (T[]) new Comparable[size * 2 + 1];
        for (int i = 0; i < size; i++) {
            if (data.get(i) == null) {
                throw new IllegalArgumentException("error, item in data is null"
                    );
            }
            backingArray[i + 1] = data.get(i);
        }
        for (int i = size / 2; i > 0; i--) {
            heapify(i);
        }
    }

    /**
     * Helper method for MaxHeap
     * Heapifies the index. Should be used in a for-loop from size / 2 to 0
     *
     * @param index the index whose subtree gets heapified
     */
    private void heapify(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        if (index * 2 < size && backingArray[left] != null
                && (backingArray[index].compareTo(backingArray[left]) < 0
                || (backingArray[right] != null && backingArray[index]
                .compareTo(backingArray[right]) < 0))) {
            int max;
            if (backingArray[right] == null) {
                max = left;
            } else {
                if (backingArray[left].compareTo(backingArray[right]) > 0) {
                    max = left;
                } else {
                    max = right;
                }
            }
            T temp = backingArray[index];
            backingArray[index] = backingArray[max];
            backingArray[max] = temp;
            heapify(max);
        }
    }

    /**
     * Adds an item to the heap. Assumes no duplicates will be added.
     *
     * @throws IllegalArgumentException if the item is null
     * @param item the item to be added to the heap
     */
    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("error: cannot add null data");
        }
        if (size >= backingArray.length - 1) {
            T[] temp = (T[]) new Comparable[(int) (2 * backingArray.length)];
            for (int i = 1; i < backingArray.length; i++) {
                temp[i] = backingArray[i];
            }
            backingArray = temp;
        }
        backingArray[++size] = item;
        int child = size;
        int parent = size / 2;
        T temp;
        while (child > 1
            && backingArray[child].compareTo(backingArray[parent]) > 0) {
            temp = backingArray[parent];
            backingArray[parent] = backingArray[child];
            backingArray[child] = temp;
            child = parent;
            parent = child / 2;
        }
    }

    /**
     * Removes and returns the first item of the heap. Null out all elements not
     * existing in the heap after this operation. Do not decrease the capacity
     * of the backing array.
     *
     * @throws java.util.NoSuchElementException if the heap is empty
     * @return the item removed
     */
    @Override
    public T remove() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("error, heap is empty");
        }
        int largerChild;
        T result = backingArray[1];
        T temp;
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        int index = 1;
        size--;
        while ((index * 2) <= size) {
            if (backingArray[index * 2 + 1] != null) {
                if (backingArray[index * 2].compareTo(backingArray[index
                    * 2 + 1]) > 0) {
                    largerChild = index * 2;
                } else {
                    largerChild = index * 2 + 1;
                }
            } else {
                largerChild = index * 2;
            }
            if (backingArray[index].compareTo(backingArray[largerChild])
                    < 0) {
                temp = backingArray[index];
                backingArray[index] = backingArray[largerChild];
                backingArray[largerChild] = temp;
                index = largerChild;
            }
            index = largerChild;
        }
        return result;
    }

    /**
     * Returns if the heap is empty or not.
     *
     * @return a boolean representing if the heap is empty
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    /**
     * Returns the size of the heap.
     *
     * @return the size of the heap
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Clears the heap and returns array to starting capacity.
     */
    @Override
    public void clear() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Used for grading purposes only.
     *
     * @return the backing array
     */
    @Override
    public Comparable[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }
}