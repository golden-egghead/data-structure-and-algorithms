package linked_list;

public class DLL<T> {
    protected DLLNode<T> head, tail;

    public DLL() {
        head = tail = null;
    }

    public DLLNode<T> getHead() {
        return head;
    }

    public void setHead(DLLNode<T> head) {
        this.head = head;
    }

    public DLLNode<T> getTail() {
        return tail;
    }

    public void setTail(DLLNode<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addTohead(T e1) {
        this.head = new DLLNode<T>(e1, this.head);
        if (this.tail == null) {
            this.tail = this.head;
        }
    }

    public void addToTail(T e1) {
        if(!isEmpty()) {
            this.tail.next = new DLLNode<T>(this.tail, e1);
            this.tail = this.tail.next;
         } else {
            this.head = this.tail = new DLLNode<T>(this.tail, e1);
         }
    }

    public T deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        T e1 = this.head.info;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }
        return e1;
    }

    public T deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        T e1 = this.tail.info;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            DLLNode<T> tmp;
            for (tmp = this.head; tmp.next != this.tail; tmp = tmp.next) {
                this.tail = tmp;
                this.tail.next = null;
            }
        }

        return e1;
    }

    public void delete(T e1) {
        if (!isEmpty()) {
            if (this.head == this.tail && e1.equals(this.head.info)) {
                this.head = this.tail = null;
            } else if (e1.equals(this.head.info)) {
                this.head = this.head.next;
            } else {
                DLLNode<T> pred, tmp;
                for (pred = this.head, tmp = this.head.next; tmp != null
                        && !(tmp.info.equals(e1)); pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == this.tail) {
                        this.tail = pred;
                    }
                }
            }
        }
    }

    public void printAll() {
        for (DLLNode<T> tmp = this.head; tmp != null; tmp = tmp.next) {
            System.out.println(tmp.info);
        }
    }

    public boolean isInList(T e1) {
        DLLNode<T> tmp;
        for(tmp = this.head; tmp != null && !tmp.info.equals(e1); tmp = tmp.next);
        return tmp != null;
    }

}
