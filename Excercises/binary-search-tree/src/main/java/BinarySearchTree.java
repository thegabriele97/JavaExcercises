import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private Node<T> nil;

    /**
     * constructor of BST
     */
    BinarySearchTree() {
        this.root = null;
        this.nil = new Node<T>(null, null);
    }

    void insert(T value) {
        Node<T> prev = null;
        Node<T> newNode = new Node<T>(value, nil);

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

        visitInorderRecursive(getRoot(), nil, traversalInOrder);
        return traversalInOrder;
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return root;
    }

    private void visitInorderRecursive(Node<T> node, Node<T> nil, List<T> traversal) {

        if (node == nil) {
            return;
        }

        visitInorderRecursive(node.getLeft(), nil, traversal);
        traversal.add(node.getData());
        visitInorderRecursive(node.getRight(), nil, traversal);
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
