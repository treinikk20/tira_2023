package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {

    class TreeNode<Key extends Comparable<K>, Value> {

        private Pair<K, V> pair;
        private TreeNode<K, V> left;
        private TreeNode<K, V> right;
        protected int childrenCount;

        public TreeNode(Pair<K, V> pair) {
            this.pair = pair;
            left = null;
            right = null;
        }

        private Pair<K, V> getPair() {
            return pair;
        }
    }

    private TreeNode<K, V> root;
    private Comparator<K> comparator;
    private int size;

    public BinarySearchTreeContainer(Comparator<K> comparator) {
        this.root = null;
        this.comparator = comparator;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }

        Pair<K, V> pair = new Pair<>(key, value);
        root = addRecursive(root, pair);
    }


    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        return getRecursive(root, key);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        /*if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        if (root == null) {
            throw new IllegalArgumentException("Cannot remove, root null");
        }

        size--;
        RemoveResult<K, V> result = removeRecursive(root, key);
        root = result.root;
        return result.value;
    */
    return null;
    }   

    @Override
    public V find(Predicate<V> searcher) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot find, root null");
        }

        return findRecursive(root, searcher);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {}

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getIndexRecursive(root, index);
    }

    private Pair<K, V> getIndexRecursive(TreeNode<K, V> root, int index) {
        if (root == null) {
            return null;
        }
        
        int leftCount = (root.left != null) ? root.left.childrenCount + 1 : 0;

        if (index < leftCount) {
            return getIndexRecursive(root.left, index);
        } else if (index > leftCount) {
            return getIndexRecursive(root.right, index - leftCount - 1);
        } else {
            return root.pair;
        }
    }

    @Override
    public int indexOf(K itemKey) {
        return indexOfRecursive(root, itemKey);
    }

    private int indexOfRecursive(TreeNode<K, V> root, K itemKey) {
        if (root == null) {
            return -1;
        }

        int leftCount = (root.left != null) ? root.left.childrenCount + 1 : 0;

        int comparison = comparator.compare(itemKey, root.getPair().getKey());
        if (comparison < 0) {
            return indexOfRecursive(root.left, itemKey);
        } else if (comparison > 0) {
            int rightIndex = indexOfRecursive(root.right, itemKey);
            if (rightIndex == -1) {
                return -1;
            }
            return rightIndex + leftCount + 1;
        } else {
            return leftCount;
        }
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot find index, root null");
        }
        return findIndexRecursive(root, searcher);
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        @SuppressWarnings("unchecked")
        Pair<K, V>[] array = new Pair[size];
        int index = 0;

        StackImplementation<TreeNode<K, V>> stack = new StackImplementation<>();
        TreeNode<K, V> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            array[index++] = current.pair;
            current = current.right;
        }

        return array;
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {}


    private TreeNode<K, V> addRecursive(TreeNode<K, V> root, Pair<K, V> pair) {
        if (root == null) {
            size++;
            return new TreeNode<>(pair);
        }

        int comparison = comparator.compare(pair.getKey(), root.getPair().getKey());

         if (comparison <= 0) {
            root.left = addRecursive(root.left, pair);
            root.childrenCount++;
        } else if (comparison > 0) {
            root.right = addRecursive(root.right, pair);
            root.childrenCount++;
        }
        
        return root;
    }

    private V getRecursive(TreeNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        int comparison = comparator.compare(key, root.getPair().getKey());

        if (comparison == 0) {
            return root.getPair().getValue();
        }

        if (comparison < 0) {
            return getRecursive(root.left, key);
        } else if (comparison > 0) {
            return getRecursive(root.right, key);
        }

        return null;
    }

    public int findMaxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode<K, V> root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    
    /*private RemoveResult<K, V> removeRecursive(TreeNode<K, V> root, K key) {
        if (root == null) {
            return new RemoveResult<>(null, null);
        }

        int comparison = comparator.compare(key, root.getPair().getKey());
        if (comparison < 0) {
            RemoveResult<K, V> leftResult = removeRecursive(root.left, key);
            root.left = leftResult.root;
            root.childrenCount--;
            return new RemoveResult<>(root, leftResult.value);

        } else if (comparison > 0) {
            RemoveResult<K, V> rightResult = removeRecursive(root.right, key);
            root.right = rightResult.root;
            root.childrenCount--;
            return new RemoveResult<>(root, rightResult.value);

        } else {
            V removedValue = root.getPair().getValue();
            if (root.left == null) {
                return new RemoveResult<>(root.right, removedValue);
            } else if (root.right == null) {
                return new RemoveResult<>(root.left, removedValue);
            } else {
                TreeNode<K, V> successor = findMinimum(root.right);
                root.pair = successor.pair;
                RemoveResult<K, V> rightResult = removeRecursive(root.right, successor.getPair().getKey());
                root.right = rightResult.root;
                root.childrenCount--;
                return new RemoveResult<>(root, removedValue);
            }
        }   
    }

    private class RemoveResult<Key, Value> {
        TreeNode<K, V> root;
        V value;
    
        RemoveResult(TreeNode<K, V> root, V value) {
            this.root = root;
            this.value = value;
        }
    
    }

    private TreeNode<K, V> findMinimum(TreeNode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }*/

    private V findRecursive(TreeNode<K, V> root, Predicate<V> searcher) {
        if (root == null) {
            return null;
        }

        V leftResult = findRecursive(root.left, searcher);
        if (leftResult != null) {
            return leftResult;
        }

        if (searcher.test(root.getPair().getValue())) {
            return root.getPair().getValue();
        }

        return findRecursive(root.right, searcher);
    }

    private int countNodes(TreeNode<K, V> node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private int findIndexRecursive(TreeNode<K, V> root, Predicate<V> searcher) {
        if (root == null) {
            return -1;
        }

        int leftIndex = findIndexRecursive(root.left, searcher);

        if (leftIndex != -1) {
            return leftIndex;
        }

        if (searcher.test(root.getPair().getValue())) {
            return countNodes(root.left);
        }

        int rightIndex = findIndexRecursive(root.right, searcher);

        if (rightIndex != -1) {
            return countNodes(root.left) + 1 + rightIndex;
        }

        return -1;
    }
}