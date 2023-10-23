package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    private int size = 0;
    private int capacity = DEFAULT_STACK_SIZE;
    private static final int DEFAULT_STACK_SIZE = 10;


    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
    }

    public StackImplementation(int stackSize) throws IllegalArgumentException {
        if (stackSize < 2) {
            throw new IllegalArgumentException("Stack too small!");
        }
        itemArray = new Object[stackSize];
        capacity = stackSize;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Cannot push a null element to stack.");
        }
        if (capacity == size) {
            reallocateArray(capacity);
        }
        itemArray[size++] = element;
    }

    @Override
    public E pop() throws IllegalStateException {
        E element = peek();
        size--;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack empty, cannot peek.");
        }
        return (E) itemArray[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        capacity = 0;
        itemArray = new Object[DEFAULT_STACK_SIZE];
    }
    
    private void reallocateArray(int capacity) {
        capacity *= 2;
        Object [] itemArrayCopy = new Object[capacity];
        for (int i = 0; i < capacity(); i++) {
            itemArrayCopy[i] = itemArray[i];
        }
        itemArray = itemArrayCopy;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("[");
       for (int i = 0; i < size; i++) {
          if (i == size - 1) {
             sb.append(itemArray[i]);
          } else {
             sb.append(itemArray[i] + ", ");
          }
       }
       sb.append("]");
       return sb.toString();
    }
}
