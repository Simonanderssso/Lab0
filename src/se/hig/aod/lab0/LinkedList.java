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
        if (head == null) {
            return true;
        } else return false;
    }

    @Override
    public void clear() {


    }

    @Override
    public int numberOfElements() {
        return 0;
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

    }

    @Override
    public T removeFirst() {
        if(isEmpty()){ throw new ListEmptyException("List is empty");
            T value = head.data;
            head = head.next;
            size--;


        return null;
    }

    @Override
    public T removeLast() {
        return null;
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
