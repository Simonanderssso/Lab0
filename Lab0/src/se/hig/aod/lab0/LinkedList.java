package se.hig.aod.lab0;

public class LinkedList<T> implements List<T> {

    private ListNode head;

    private int size;

    private class ListNode {
        T data;
        ListNode next;

        ListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int numberOfElements() {

        return size;
    }

    @Override
    public void insertFirst(T t) {
    ListNode newNode = new ListNode(t);
    newNode.next = head;
    head = newNode;
    size++;
    }

    @Override
    public void insertLast(T t) {
        if (isEmpty()) {
            insertFirst(t);
        return;
    }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new ListNode(t);
        size++;
    }


    @Override
    public T removeFirst() {
        if(isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
            T value = head.data;
            head = head.next;
            size--;
            return value;
    }

    @Override
    public T removeLast() {
            if(isEmpty()) { throw new ListEmptyException("List is empty");
        }
        if (head.next == null) {
            T value = head.data;
            head = null;
            size--;
            return value;
        }
        ListNode current = head;
        while (current.next.next != null){
            current = current.next;
        }
        T value = current.next.data;
        current.next = null;
        size--;
        return value;
    }

    @Override
    public T getFirst() {
        if(isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        return null;
    }
}
