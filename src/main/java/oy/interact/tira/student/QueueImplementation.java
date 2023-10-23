package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {

    private Object [] itemArray;
    private int capacity = DEFAULT_QUEUE_SIZE;
    private int queueHead;
    private int queueTail;
    private int size;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation() {
        itemArray = new Object[DEFAULT_QUEUE_SIZE];
        queueHead = 0;
        queueTail = 0;
        size = 0;
    }

    public QueueImplementation(int queueSize) throws IllegalArgumentException {
        if (queueSize < 2) {
            throw new IllegalArgumentException("Queue too small!");
        }
        itemArray = new Object[queueSize];
        capacity = queueSize;
        queueHead = 0;
        queueTail = 0;
        size = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(Object element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Cannot add null to queue.");
        }
        if (capacity == size) {
            reallocateArray(capacity);
        }
        itemArray[queueTail] = element;
        queueTail++;
        size++;
        if (queueTail == capacity) {
            queueTail = 0;
        }
    }

    @Override
    public E dequeue() throws IllegalStateException {
        E element = element();
        itemArray[queueHead] = null;
        queueHead++;
        size--;
        if (queueHead == capacity) {
            queueHead = 0;
        }
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E element() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("Queue empty, no element to access.");
        }
        return (E) itemArray[queueHead];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        size = 0;
        queueHead = 0;
        queueTail = 0;
        capacity = DEFAULT_QUEUE_SIZE;
        itemArray = new Object[capacity];
    }
    
    private void reallocateArray(int capacity) {
        capacity *= 2;
        int i = 0;
        Object [] itemArrayCopy = new Object[capacity];
        for (i = 0; i < this.capacity; i++) {
            itemArrayCopy[i] = dequeue();
        }
        queueHead = 0;
        queueTail = i;
        size = i;
        this.capacity = capacity;
        itemArray = itemArrayCopy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = queueHead;
        int j = size;
        if (j == 0) {
            sb.append("[]");
            return sb.toString();
        }
        sb.append("[");
        while (j != 0) {
            sb.append(itemArray[i] + ", ");
            i++;
            j--;
            if (i == capacity) {
                i = 0;
            }
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}