/**
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */

public class SinglyLinkedList<T> implements LinkedListInterface<T> {
    // Do not add new instance variables or modify existing ones.
    private LinkedListNode<T> head;
    private int size;

    /**
     * Adds the element to the index specified.
     *
     * @param index the requested index for the new element
     * @param data the data for the new element
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index > size
     * @throws java.lang.IllegalArgumentException if data is null
     */
    @Override
    public void addAtIndex(T data, int index) throws IllegalArgumentException,
        IndexOutOfBoundsException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error, " + (index < 0 ? "index"
                + " is negative." : "index is greater than size of list."));
        }

        if (index == 0) {
            addToFront(data);
        } else {
            LinkedListNode<T> tempNode = new LinkedListNode<T>(data);
            LinkedListNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            tempNode.setNext(currentNode.getNext());
            currentNode.setNext(tempNode);

            size++;
        }
    }

    /**
     * Adds the element to the front of the list.
     *
     * @param data the data for the new element
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToFront(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        LinkedListNode<T> tempNode = new LinkedListNode<T>(data);

        if (size == 0) {
            head = tempNode;
            head.setNext(head);
        } else {
            tempNode.setData(head.getData());
            tempNode.setNext(head.getNext());
            head.setData(data);
            head.setNext(tempNode);
        }

        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * @param data the data for the new element
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToBack(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }

        LinkedListNode<T> tempNode = new LinkedListNode<T>(data);

        if (size == 0) {
            head = tempNode;
            head.setNext(head);
        } else {
            tempNode.setData(head.getData());
            tempNode.setNext(head.getNext());
            head.setData(data);
            head.setNext(tempNode);
            head = head.getNext();
        }

        size++;
    }

    /**
     * Removes and returns the element from the index specified.
     *
     * @param index the requested index to be removed
     * @return the data formerly located at index
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index >= size
     */
    @Override
    public T removeAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, " + (index < 0 ? "index"
                + " is negative." : "index is greater than or equal to size of"
                + " list."));
        }

        T result = null;


        if (index == 0) {
            return removeFromFront();
        }

        LinkedListNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        result = currentNode.getData();

        LinkedListNode<T> nodeBefInd = head;
        for (int i = 0; i < index - 1; i++) {
            nodeBefInd = nodeBefInd.getNext();
        }
        LinkedListNode<T> nodeAftInd = head;
        for (int i = 0; i < index + 1; i++) {
            nodeAftInd = nodeAftInd.getNext();
        }
        nodeBefInd.setNext(nodeAftInd);

        size--;

        return result;
    }

    /**
     * Removes and returns the element at the front of the list. If the list is
     * empty, return {@code null}.
     *
     * @return the data formerly located at the front, null if empty list
     */
    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T result = head.getData();

        head.setData(head.getNext().getData());
        head.setNext(head.getNext().getNext());

        size--;
        return result;
    }

    /**
     * Removes and returns the element at the back of the list. If the list is
     * empty, return {@code null}.
     *
     * @return the data formerly located at the back, null if empty list
     */
    @Override
    public T removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        T result = head.getData();

        LinkedListNode<T> tempNode = head;
        for (int i = 0; i < size - 1; i++) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(head);
        result = tempNode.getData();

        size--;
        return result;
    }

    /**
     * Removes the last copy of the given data from the list.
     *
     * @param data the data to be removed from the list
     * @return the removed data occurrence from the list itself (not the data
     * passed in), null if no occurrence
     * @throws java.lang.IllegalArgumentException if data is null
     */
    @Override
    public T removeLastOccurrence(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Error, data is null.");
        }
        T result = null;
        LinkedListNode<T> tempNode = head;
        int numOfOcc = 0;
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (tempNode.getData() == data) {
                numOfOcc++;
                ind = i;
            }
            tempNode = tempNode.getNext();
        }
        if (numOfOcc == 0) {
            return result;
        } else {
            result = removeAtIndex(ind);
        }
        return result;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the requested element
     * @return the object stored at index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, " + (index < 0 ? "index"
                + " is negative." : "index is greater than or equal to size of"
                + " list."));
        }

        if (index == 0) {
            return head.getData();
        } else {
            LinkedListNode<T> result = head;
            for (int i = 0; i < index; i++) {
                result = result.getNext();
            }
            return result.getData();
        }
    }

    /**
     * Returns an array representation of the linked list.
     *
     * @return an array of length {@code size} holding all of the objects in
     * this list in the same order
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];

        for (int i = 0; i < size; i++) {
            result[i] = this.get(i);
        }

        return result;
    }

    /**
     * Returns a boolean value indicating if the list is empty.
     *
     * @return true if empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list of all data.
     */
    @Override
    public void clear() {
        head = new LinkedListNode<T>(null, null);
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        // DO NOT MODIFY!
        return size;
    }

    /**
     * Returns the head node of the linked list.
     *
     * @return node at the head of the linked list
     */
    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}