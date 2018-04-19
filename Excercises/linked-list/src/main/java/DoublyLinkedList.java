import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {
    private Node head;
    private Node tail;

    @Override
    public void push(T e) {
        Node newNode = new Node(tail, e, null);

        if (head == null) {
            tail = newNode;
            head = tail;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public T pop() {
        
        Node tmp = tail;
        tail = tail.getPrev();
        
        if (tail != null) {
            tail.next = null;
        }

        return tmp.getItem();
    }

    @Override
    public T shift() {

        Node tmp = head;
        head = head.next;
        
        if (head != null) {
            head.prev = null;
        }

        return tmp.getItem();
    }

    @Override
    public void unshift(T e) {
        Node newNode = new Node(null, e, head);

        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }

        head = newNode;
        head.next.prev = newNode;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        private Node(Node prev, T item, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        private Node getPrev() {
            return prev;
        }

        private Node getNext() {
            return next;
        }

        private T getItem() {
            return item;
        }
    }
}