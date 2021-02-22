package edu.wcw;

public class WNode<T> {

    private T val;
    private WNode<T> next;

    public WNode(T val, WNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public final T getVal() {
        return val;
    }
    public final WNode<T> getNext() {
        return next;
    }
    
    
}
