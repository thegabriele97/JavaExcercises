import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private Node<T> nil;
    private int numberOfNodes;

    /**
     * constructor of BST
     */
    BinarySearchTree() {
        this.root = null;
        this.nil = new Node<T>(null, null);
        this.numberOfNodes = 0;
    }

    void insert(T value) {
        Node<T> prev = null;
        Node<T> newNode = new Node<T>(value, nil);
        
        numberOfNodes++;

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> curr = this.root;
        while (curr != nil) {
            int cmp = value.compareTo(curr.getData());

            prev = curr;
            curr = (cmp <= 0) ? curr.getLeft() : curr.getRight();
        }

        int cmp = value.compareTo(prev.getData());
        if (cmp <= 0) {
            prev.left = newNode;
        } else if (cmp > 0) {
            prev.right = newNode;
        }
    }
 
    List<T> getAsSortedList() {
        List<T> traversalInOrder = new ArrayList<>();

        visitInorderRecursive(getRoot(), nil, traversalInOrder, null, 0);
        return traversalInOrder;
    }

    List<T> getAsLevelOrderList() {
        List<T> traversalInorder = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();

        visitInorderRecursive(getRoot(), nil, traversalInorder, levels, 0);
        sortListsTraversalToghether(traversalInorder, levels);

        return traversalInorder;
    }

    Node<T> getRoot() {
        return root;
    }

    private static <T> void sortListsTraversalToghether(List<T> list1, List<Integer> list2) {
        Integer[] array2 = new Integer[list2.size()];
        Object[] array1;

        array1 = list1.toArray();
        array2 = list2.toArray(array2);

        if (array1.length != array2.length) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < array1.length; i++) {
            int curr = i;
            int tmp2 = array2[curr];
            Object tmp1 = array1[curr];
            
            while (curr > 0 && array2[curr - 1] > tmp2) {
                array1[curr] = array1[curr - 1];
                array2[curr] = array2[curr - 1];
                curr--;
            }

            array1[curr] = tmp1;
            array2[curr] = tmp2;
        }

        list1.clear();
        list2.clear();

        for (int i = 0; i < array1.length; i++) {
            list1.add((T)array1[i]);
            list2.add(array2[i]);
        }
    }

    private void visitInorderRecursive(Node<T> node, Node<T> nil, List<T> traversal, List<Integer> levelOrder, int currentLevel) {

        if (node == nil) {
            return;
        }

        visitInorderRecursive(node.getLeft(), nil, traversal, levelOrder, currentLevel + 1);
        
        if (traversal != null) {
            traversal.add(node.getData());
        }

        if (levelOrder != null) {
            levelOrder.add(currentLevel);
        }
        
        visitInorderRecursive(node.getRight(), nil, traversal, levelOrder, currentLevel + 1);
    }

    static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        /**
         * constructor of node
         */
        private Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        private Node(T data, Node<T> nil) {
            this(data, nil, nil);
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

    }
}
