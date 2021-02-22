package edu.wcw;

public class WFixedCapacityStackOfInts {
    private final int[] a;

    private int n = 0;

    public WFixedCapacityStackOfInts(int capacity) throws Exception {
        if (capacity < 0)
            throw new Exception("参数错误！");
        a = new int[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(int t) throws Exception {
        if (n == a.length)
            throw new Exception("Stack 已满，不能添加数据");
        a[n++] = t;
    }

    public int pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack 已空");
        int temp = a[--n];
        return temp;
    }

    public int peek() {
        return isEmpty() ? null : a[n - 1];
    }
}
