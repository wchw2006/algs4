package edu.wcw;

public class WFixedCapacityStack<T> {
    private T[] a;
    private int n = 0;

    public WFixedCapacityStack(int capacity) throws Exception {
        if (capacity < 0)
            throw new Exception("参数错误！");
        a = (T[])new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T t) {
        if (n == a.length) {

        }
        a[n++] = t;
    }

    public T pop() {
        T temp = a[--n];
        a[n] = null;
        return temp;
    }

    public T peek() {
        return a[n - 1];
    }

}
