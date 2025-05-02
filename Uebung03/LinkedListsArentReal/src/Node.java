public class Node {
    private int value;
    private Node next, prev;
    public Node(int value_) {
        value = value_;
    }
    public void setNext(Node next_) {
        this.next = next_;
    }
    public void setPrev(Node prev_) {
        this.prev = prev_;
    }
    public void setValue(int value_) {
        value = value_;
    }
    public int getValue() {
        return value;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrev() {
        return prev;
    }
}
