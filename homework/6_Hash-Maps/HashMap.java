import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Your implementation of HashMap.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

    // Do not make any new instance variables.
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Create a hash map with no entries.
     */
    public HashMap() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Create a hash map with no entries.
     *
     * Assume {@code initialCapacity} will always be positive.
     *
     * @param initialCapacity initial capacity of the backing array
     */
    public HashMap(int initialCapacity) {
        table = new MapEntry[initialCapacity];
        size = 0;
    }

    /**
     * Adds the given key-value pair to the HashMap
     *
     * @param key key to add into the HashMap
     * @param value value to add into the HashMap
     * @throws IllegalArgumentException if key or value is null
     * @return null if the key was not already in the map.  If it was in the
     * map, return the old value associated with it
     */
    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("error, cannot put null key");
        } else if (value == null) {
            throw new IllegalArgumentException("error, cannot put null value");
        }
        V tempValue;
        if (((double) (size + 1) / (double) (table.length)) > MAX_LOAD_FACTOR) {
            resizeBackingTable(table.length * 2 + 1);
        }
        int hashnumber = Math.abs(key.hashCode() % table.length);
        if (table[hashnumber] == null) {
            table[hashnumber] = new MapEntry<K, V>(key, value);
            size++;
            return null;
        } else {
            MapEntry<K, V> check = table[hashnumber];
            do {
                if (check.getKey().equals(key)) {
                    tempValue = check.getValue();
                    check.setValue(value);
                    return tempValue;
                }
                if (check.getNext() != null) {
                    check = check.getNext();
                }
            } while (check.getNext() != null);
            if (check.getKey().equals(key)) {
                tempValue = check.getValue();
                check.setValue(value);
                return tempValue;
            }
            MapEntry<K, V> tempEntry = new MapEntry(key, value,
                table[hashnumber]);
            table[hashnumber] = tempEntry;
            size++;
            return null;
        }
    }

    /**
     * Removes the entry with a matching key from the HashMap.
     *
     * @param key the key to remove
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key does not exist
     * @return the value previously associated with the key
     */
    @Override
    public V remove(K key) {
        MapEntry<K, V> tempEntry;
        int counter = 0;
        if (key == null) {
            throw new IllegalArgumentException("error, cannot remove null key");
        }

        int hashnumber = Math.abs(key.hashCode() % table.length);
        if (table[hashnumber] == null) {
            throw new java.util.NoSuchElementException("error, key does not "
                + "exist");
        } else {
            MapEntry<K, V> check = table[hashnumber];
            do {
                if (check.getKey().equals(key)) {
                    if (counter == 0) {
                        if (check.getNext() == null) {
                            table[hashnumber] = null;
                        } else {
                            table[hashnumber] = check.getNext();
                        }
                    } else {
                        tempEntry = table[hashnumber];
                        for (int i = 0; i < counter - 1; i++) {
                            tempEntry = tempEntry.getNext();
                        }
                        if (check.getNext() == null) {
                            tempEntry.setNext(null);
                        } else {
                            tempEntry.setNext(check.getNext());
                        }
                    }
                    size--;
                    return check.getValue();
                }
                if (check.getNext() != null) {
                    check = check.getNext();
                }
                counter++;
            } while (check.getNext() != null);
            if (check.getKey().equals(key)) {
                if (counter == 0) {
                    if (check.getNext() == null) {
                        table[hashnumber] = null;
                    } else {
                        table[hashnumber] = check.getNext();
                    }
                } else {
                    tempEntry = table[hashnumber];
                    for (int i = 0; i < counter - 1; i++) {
                        tempEntry = tempEntry.getNext();
                    }
                    if (check.getNext() == null) {
                        tempEntry.setNext(null);
                    } else {
                        tempEntry.setNext(check.getNext());
                    }
                }
                size--;
                return check.getValue();
            }
            throw new java.util.NoSuchElementException("error, key does not "
                + "exist");
        }
    }

    /**
     * Gets the value associated with the given key.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key is not in the map
     * @return the value associated with the given key
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("error, cannot get null key");
        }
        int hashnumber = Math.abs(key.hashCode() % table.length);
        if (table[hashnumber] == null) {
            throw new java.util.NoSuchElementException("error, key not exist");
        } else {
            MapEntry<K, V> check = table[hashnumber];
            do {
                if (check.getKey().equals(key)) {
                    return check.getValue();
                }
                if (check.getNext() != null) {
                    check = check.getNext();
                }
            } while (check.getNext() != null);
            if (check.getKey().equals(key)) {
                return check.getValue();
            }
            throw new java.util.NoSuchElementException("error, key not exist");
        }
    }

    /**
     * Returns whether or not the key is in the map.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @return whether or not the key is in the map
     */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("error, cannot check null key");
        }
        int hashnumber = Math.abs(key.hashCode() % table.length);
        if (table[hashnumber] == null) {
            return false;
        } else {
            MapEntry<K, V> check = table[hashnumber];
            do {
                if (check.getKey().equals(key)) {
                    return true;
                }
                if (check.getNext() != null) {
                    check = check.getNext();
                }
            } while (check.getNext() != null);
            if (check.getKey().equals(key)) {
                return true;
            }
            return false;
        }
    }

    /**
     * Clears the table and resets it to the default length.
     */
    @Override
    public void clear() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in the map.
     *
     * @return number of elements in the HashMap
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns a Set view of the keys contained in this map.
     * Use {@code java.util.HashSet}.
     *
     * @return set of keys in this map
     */
    @Override
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<K>(size);
        for (MapEntry<K, V> item: table) {
            if (item != null) {
                keys.add(item.getKey());
                while (item.getNext() != null) {
                    item = item.getNext();
                    keys.add(item.getKey());
                }
            }
        }
        return keys;
    }

    /**
     * Returns a List view of the values contained in this map.
     *
     * @return list of values in this map
     */
    @Override
    public List<V> values() {
        List<V> values = new ArrayList<V>(size);
        for (MapEntry<K, V> item: table) {
            if (item != null) {
                values.add(item.getValue());
                while (item.getNext() != null) {
                    item = item.getNext();
                    values.add(item.getValue());
                }
            }
        }
        return values;
    }

    /**
     * Resize the backing table to {@code length}.
     *
     * @param length new length of the backing table
     * @throws IllegalArgumentException if length is non-positive or less than
     *         the number of items in the hash map.
     */
    @Override
    public void resizeBackingTable(int length) {
        int tempSize = size;
        if (length <= 0) {
            throw new IllegalArgumentException("error, length is less than 0");
        } else if (length < size) {
            throw new IllegalArgumentException("error, length is less than "
                + "size");
        }
        MapEntry<K, V> tempEntry;
        size = 0;
        MapEntry<K, V>[] tempTable = table;
        table = (MapEntry<K, V>[]) new MapEntry[length];
        for (MapEntry<K, V> item: tempTable) {
            size = 0;
            if (item != null) {
                put(item.getKey(), item.getValue());
                tempEntry = item;
                while (tempEntry.getNext() != null) {
                    put(tempEntry.getKey(), tempEntry.getValue());
                    tempEntry = tempEntry.getNext();
                }
                put(tempEntry.getKey(), tempEntry.getValue());
            }
        }
        size = tempSize;
    }

    /**
     * Returns backing array
     *
     * @return table the backing array of the data structure
     */
    @Override
    public MapEntry<K, V>[] getTable() {
        // DO NOT EDIT THIS METHOD!
        return table;
    }
}