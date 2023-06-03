package linked_list;

public class DLLNode<T> {
    T info;
    DLLNode<T> prev;
    DLLNode<T> next;
    public DLLNode() {
        this.prev = null;
        this.next = null; 
    }
    //add last
    public DLLNode(DLLNode<T> beforeEle, T e1) {
        this.info = e1;
        this.prev = beforeEle;
        this.next = null;
    }
    //add first
    public DLLNode(T e1, DLLNode<T> afterEle) {
        this.info = e1;
        this.prev = null;
        this.next = afterEle;
    }

    
}
