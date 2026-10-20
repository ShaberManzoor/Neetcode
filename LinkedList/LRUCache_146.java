package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache_146 {

    Map<Integer, Node> cache;
    Node oldest, latest;
    int cap;

    public LRUCache_146(int capacity) {
        cap = capacity;
        oldest = new Node(-1, -1);
        latest = new Node(-1, -1);
        latest.prev = oldest;
        oldest.next = latest;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            remove(oldNode);
        }

        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);

        if(cache.size()>cap) {
            Node lru = oldest.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void insert(Node node) {
        Node lastNode = latest.prev;
        lastNode.next = node;
        node.prev = lastNode;
        node.next = latest;
        latest.prev = node; 
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */