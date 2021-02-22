package edu.wcw;

import java.util.Arrays;
import java.util.Iterator;

public class WQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else {
            oldNode.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    private class Node {
        private Item item;
        private Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    private class ListIterator implements Iterator<Item> {

        private Node first;
        // private Node last;
        private int N;

        public ListIterator(WQueue<Item> queue) {
            this.first = queue.first;
            // this.last = queue.last;
            N = queue.N;
        }

        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public Item next() {
            Item item = first.item;
            first = first.next;
            if (first == null) {
                // last = null;
            }
            N--;
            return item;
        }
    }

    public static void main(String[] args) {
        String testStr = "123456789";
        String[] arr = testStr.split("");
        WQueue<String> queue = new WQueue<String>();
        Arrays.stream(arr).forEach(queue::enqueue);
        // Arrays.stream(arr).forEach(val -> stack.push(val));
        // IntStream.range(0, arr.length).forEach(index -> stack.push(arr[index]));
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
    }
}
