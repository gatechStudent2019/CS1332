import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your implementation of a binary search tree (BST).
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES. // wouldnt dream of it.
    private BSTNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty BST.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("error: data is null");
        }
        for (T t: data) {
            add(t);
        }
    }

    /**
     * Add the data as a leaf in the BST.
     *
     * @throws IllegalArgumentException if the data is null
     * @param data the data to be added
     */
    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot add null data");
        }
        root = add(data, root);
    }

    /**
     * Helper method for add(T data)
     * Adds the data to the BST and returns the root node
     *
     * @param  data the data to be added
     * @param  node the current node (inputed node should be root)
     * @return the root node
     */
    private BSTNode<T> add(T data, BSTNode<T> node) {
        if (node == null) {
            size++;
            return new BSTNode<T>(data);
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(data, node.getRight()));
        } else {
            return node;
        }
        return node;
    }

    /**
     * Removes the data from the tree.
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to remove from the tree
     * @return the data removed from the tree
     */
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot remove null data"
                );
        }
        root = remove(data, root);
        return data;
    }

    /**
     * Helper method for remove(T data)
     * Returns the node a node should become after a node with the data inputed
     * is found and removed.
     *
     * @param  data data to be removed
     * @param  node current node (input should be root)
     * @return the node removed
     */
    private BSTNode<T> remove(T data, BSTNode<T> node) {
        if (node == null) {
            throw new java.util.NoSuchElementException("error: data not found");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(remove(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(remove(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                size--;
                return node.getRight();
            } else if (node.getRight() == null) {
                size--;
                return node.getLeft();
            } else {
                node.setData(predecessor(node).getData());
                node.setLeft(remove(node.getData(), node.getLeft()));
            }
        }
        return node;
    }

    /**
     * Determines the predecessor of a given node
     *
     * @param node the node you want the predecessor of
     * @return the predeccesor
     */
    private BSTNode<T> predecessor(BSTNode<T> node) {
        node = node.getLeft();
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    /**
     * Returns the data in the tree matching the parameter passed in
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to search for in the tree.
     * @return the data in the tree equal to the parameter.
     */
    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot get null data");
        } else {
            return get(data, root).getData();
        }
    }

    /**
     * Helper method for get(T data)
     * Returns the node that contains the data passed in
     *
     * @param  data the data you want your node to contain
     * @param  node the current node (inputed node should be root)
     * @throws IllegalArgumentException if the data is null
     * @return the desired node
     */
    private BSTNode<T> get(T data, BSTNode<T> node) {
        if (node == null) {
            throw new java.util.NoSuchElementException("error: data not found");
        } else if (data.compareTo(node.getData()) == 0) {
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            return get(data, node.getLeft());
        } else {
            return get(data, node.getRight());
        }
    }

    /**
     * Returns whether or not data equivalent to the given parameter
     *
     * @throws IllegalArgumentException if the data is null
     * @param data the data to search for in the tree.
     * @return whether or not the parameter is contained within the tree.
     */
    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("error: cannot check null data");
        }
        return get(data, root) != null;
    }

    /**
     * Generate a pre-order traversal of the tree.
     *
     * @return a preorder traversal of the tree
     */
    @Override
    public List<T> preorder() {
        List<T> list = new LinkedList<>();
        return preorder(root, list);

    }

    /**
     * Helper method for preorder()
     * Returns a preordered list of the BST
     *
     * @param  node the current node (inputed node should be root)
     * @param  list the list the preorder will be added to (should be new)
     * @return a preorderd list of the BST
     **/
    private List<T> preorder(BSTNode<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            preorder(node.getLeft(), list);
            preorder(node.getRight(), list);
        } else {
            return list;
        }
        return list;
    }

    /**
     * Generate a post-order traversal of the tree.
     *
     * @return a postorder traversal of the tree
     */
    @Override
    public List<T> postorder() {
        List<T> list = new LinkedList<>();
        return postorder(root, list);

    }

    /**
     * Helper method for postorder()
     * Returns a postordered list of the BST
     *
     * @param  node the current node (inputed node should be root)
     * @param  list the list the postorder will be added to (should be new)
     * @return a postordered list of the BST
     **/
    private List<T> postorder(BSTNode<T> node, List<T> list) {
        if (node != null) {
            postorder(node.getLeft(), list);
            postorder(node.getRight(), list);
            list.add(node.getData());
        } else {
            return list;
        }
        return list;
    }

    /**
     * Generate an in-order traversal of the tree.
     *
     * @return a postorder traversal of the tree
     */
    @Override
    public List<T> inorder() {
        List<T> list = new LinkedList<>();
        return inorder(root, list);
    }

    /**
     * Helper method for inorder()
     * Returns a inordered list of the BST
     *
     * @param  node the current node (inputed node should be root)
     * @param  list the list the inorder will be added to (should be new)
     * @return a inordered list of the BST
     **/
    private List<T> inorder(BSTNode<T> node, List<T> list) {
        if (node != null) {
            inorder(node.getLeft(), list);
            list.add(node.getData());
            inorder(node.getRight(), list);
        } else {
            return list;
        }
        return list;
    }

    /**
     * Generate a level-order traversal of the tree.
     *
     * @return a level order traversal of the tree
     */
    @Override
    public List<T> levelorder() {
        List<T> list = new LinkedList<>();
        Queue<BSTNode<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            BSTNode<T> temp = queue.remove();
            list.add(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return list;
    }

    /**
     * Calculates the shortest distance between two elements in the tree.
     *
     * @param data1 the data to start the path from
     * @param data2 the data to end the path on
     * @return the shortest distance between the two data in the tree
     * @throws IllegalArgumentException if either data1 or data2 is null
     * @throws java.util.NoSuchElementException if data1 or data2 is not in
     * the tree
     */
    @Override
    public int distanceBetween(T data1, T data2) {
        if (data1 == null || data2 == null) {
            throw new IllegalArgumentException("error: cannot check null data");
        } else if (!contains(data1) || !contains(data2)) {
            throw new java.util.NoSuchElementException("error: no such data "
                + "found in BST");
        }
        return distanceBetween(data1, data2, root);
    }
    /**
     * Helper method for distanceBetween(T data1, T data2)
     * Calculates the shortest distance between two elements in the tree.
     *
     * @param  data1 the data to start the path from
     * @param  data2 the data to end the path on
     * @param  dca  current deepeset common ancestor (input should be root)
     * @return the shortest distance between the two data in the tree
     */
    private int distanceBetween(T data1, T data2, BSTNode<T> dca) {
        int counter = 0;
        if (data1.compareTo(data2) == 0) {
            return counter;
        }
        if (data1.compareTo(data2) > 0) {
            T temp = data1;
            data1 = data2;
            data2 = temp;
        }
        while (data1.compareTo(dca.getData()) < 0 && data2.compareTo(dca
            .getData()) < 0) {
            dca = dca.getLeft();
        }
        while (data1.compareTo(dca.getData()) > 0 && data2.compareTo(dca
            .getData()) > 0) {
            dca = dca.getRight();
        }
        BSTNode<T> node1 = dca;
        BSTNode<T> node2 = dca;
        while (node1.getData().compareTo(data1) != 0) {
            counter++;
            if (data1.compareTo(node1.getData()) < 0) {
                node1 = node1.getLeft();
            } else {
                node1 = node1.getRight();
            }
        }
        while (node2.getData().compareTo(data2) != 0) {
            counter++;
            if (data2.compareTo(node2.getData()) < 0) {
                node2 = node2.getLeft();
            } else {
                node2 = node2.getRight();
            }
        }
        return counter;
    }

    /**
     * Clears the tree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Calculate and return the height of the root of the tree.
     *
     * @return the height of the root of the tree
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * Helper method for height()
     * Calculates and returns the height of a given node
     *
     * @param  node the given node we want the height of (should be root)
     * @return the height of the node
     **/
    private int height(BSTNode<T> node) {
        if (node == null) {
            return -1;
        }
        int lHeight = height(node.getLeft());
        int rHeight = height(node.getRight());
        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    /**
     * Returns the size of the tree
     *
     * @return the number of elements in the tree
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */
    @Override
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}