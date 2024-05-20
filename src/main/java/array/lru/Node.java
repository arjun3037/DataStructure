package array.lru;

public class Node {

    private Node prev;

    private Integer key;

    Integer value;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node next;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;

    }
}

