package edu.wcw;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class WResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[])new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T t) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = t;
    }

    public T pop() {
        T temp = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return temp;
    }

    public T peek() {
        return a[n - 1];
    }

    public void resize(int max) {
        T[] temp = (T[])new Object[max];
        IntStream.range(0, n).forEach(index -> temp[index] = a[index]);
        a = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        // 先进后出
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        String testStr = "123456789";
        String[] arr = testStr.split("");
        WResizingArrayStack<String> stack = new WResizingArrayStack<String>();
        Arrays.stream(arr).forEach(stack::push);
        // Arrays.stream(arr).forEach(val -> stack.push(val));
        // IntStream.range(0, arr.length).forEach(index -> stack.push(arr[index]));
        System.out.println(stack.toString());
        System.out.println(stack.peek());
    }
}
