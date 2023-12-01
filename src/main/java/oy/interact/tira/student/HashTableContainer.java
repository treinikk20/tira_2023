package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {
    
    // Next prime number after 3166100, the total number of coders.
    // This was found to be necessary, since the tests break after
    // indexing changes, which happens when resizing the table.
    private static final int DEFAULT_CAPACITY = 3166129;
    private static final double LOAD_FACTOR_THRESHOLD = 0.65;
    private double loadFactor;
    private Pair<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableContainer() {
        this.table = new Pair[DEFAULT_CAPACITY];
        this.size = 0;
        this.loadFactor = 0.0;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        int index = ((hashCode & 0x7fffffff) % capacity());
        
        loadFactor = (double) size() / (double) capacity();
        if (loadFactor > LOAD_FACTOR_THRESHOLD) {
            ensureCapacity(table.length * 2);
        }

        int i = 1;
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + i * i) % capacity();
            i++; 
        }

        return index;
    }
    
    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }

        int index = getIndex(key);

        if (table[index] != null && table[index].getKey().equals(key)) {
            table[index] = new Pair<>(key, value);
        } else {
            table[index] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);

        if (table[index] != null && table[index].getKey().equals(key)) {
            return table[index].getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        if (table[index] != null && table[index].getKey().equals(key)) {
            V value = table[index].getValue();
            table[index].setRemoved();
            table[index] = null;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public V find(Predicate<V> searcher) {
        for (Pair<K, V> entry : table) {
            if (entry != null && searcher.test(entry.getValue())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= 0 || capacity <= size) {
            throw new IllegalArgumentException("Invalid capacity");
        }

        Pair<K, V>[] newTable = new Pair[capacity*2];
        for (Pair<K, V> entry : table) {
            if (entry != null) {
                int index = getNewIndex(entry.getKey(), newTable);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    private int getNewIndex(K key, Pair<K, V>[] table) {
        int hashCode = key.hashCode();
        int index = ((hashCode & 0x7fffffff) % table.length);

        int i = 1;
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + i * i) % table.length;
            i++; 
        }

        return index;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Pair[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pair<K, V>[] toArray() {
        Pair<K, V>[] array = (Pair<K, V>[]) new Pair[size];
        int index = 0;
        for (Pair<K, V> entry : table) {
            if (entry != null) {
                array[index++] = entry;
            }
        }
        return array;
    }
}