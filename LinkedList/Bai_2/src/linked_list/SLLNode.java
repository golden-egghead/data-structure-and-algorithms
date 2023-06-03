package linked_list;

public class SLLNode<T> {
    T info;
    SLLNode<T> next;

    public SLLNode() {
        this.next = null;
    }

    public SLLNode (T e1) {
        this.info = e1;
        this.next = null;
    }

    public SLLNode(T e1, SLLNode<T> afterEle) {
        this.info = e1;
        this.next = afterEle;
    }


}
