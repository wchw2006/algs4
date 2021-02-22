package edu.wcw;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WStack<T> implements Iterable<T> {

    private WNode<T> first;

    private int length;

    public WStack() {
        this.first = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void push(T t) {
        WNode<T> prev = first;
        WNode<T> newVal = new WNode<T>(t, prev);
        first = newVal;
        length++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        T t = first.getVal();
        first = first.getNext();
        length--;
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.getVal();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(this.first);
    }

    private class LinkedIterator implements Iterator<T> {

        private WNode<T> current;

        public LinkedIterator(WNode<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack underflow");
            }
            T t = current.getVal();
            current = current.getNext();
            return t;
        }
    }

    public static void main(String[] args) {
        // String testStr = "123456789";
        // String[] arr = testStr.split("");
        // WStack<String> stack = new WStack<String>();
        // Arrays.stream(arr).forEach(stack::push);
        // // Arrays.stream(arr).forEach(val -> stack.push(val));
        //// IntStream.range(0, arr.length).forEach(index -> stack.push(arr[index]));
        // System.out.println(stack.toString());
        WStack<String> stack = new WStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack() ");

    }
}
