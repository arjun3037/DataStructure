package array.lru;



import java.util.HashMap;
import java.util.Map;

public class LruCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    int capacity;

    public  LruCache(int capacity){
        this.capacity=capacity;
        head.setNext(tail);
        tail.setPrev(head);
    }

    Map<Integer , Node> cache = new HashMap<>();

    public Integer get(Integer key){
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(Integer key , Integer value){
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        if (cache.size() == capacity){
            remove(tail.getPrev());
        }
        add(new Node(key,value));
    }

    private void add(Node node) {
        cache.put(node.getKey(), node);
        Node headNext = head.getNext();
        node.setPrev(head);
        node.setNext(headNext);
        head.setNext(node);
        headNext.setPrev(node);
    }

    private void remove(Node node){
        cache.remove(node.getKey());
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }


}
