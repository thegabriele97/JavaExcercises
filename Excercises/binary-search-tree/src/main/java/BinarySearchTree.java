import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    /**
     * constructor of BST
     */
    BinarySearchTree() {
        this.root = null;
    }

    void insert(T value) {
        Node<T> prev = null;
        Node<T> newNode = new Node<T>(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> curr = this.root;
        while (curr != null) {
            int cmp = value.compareTo(curr.getData());

            prev = curr;
            curr = (cmp <= 0) ? curr.left : curr.right;
        }

        int cmp = value.compareTo(prev.getData());
        if (cmp <= 0) {
            prev.left = newNode;
        } else if (cmp > 0) {
            prev.right = newNode;
        }
    }
 
    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return root;
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

        private Node(T data) {
            this(data, null, null);
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
