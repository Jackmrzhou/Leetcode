package leetcodeJava;

class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int k, int v) {
            key=k;
            val = v;
        }
    }
    int cap = 0;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        head = null;
        tail = null;
        map = new HashMap<Integer, Node>();
    }
    
    public Node _get(int key) {
        var node = map.get(Integer.valueOf(key));
        if (node != null) {
            if (node != head) {
                if (node == tail) tail = node.prev;
                var prev = node.prev;
                node.prev = null;
                var next = node.next;
                if (next != null) 
                    next.prev = prev;
                prev.next = next;
                node.next = head;
                if (head != null) 
                    head.prev = node;
                head = node;
            }
            return node;
        }
        return null;
    }
    
    public int get(int key) {
        var node = _get(key);
        if (node == null) return -1;
        return node.val;
    }
    
    public void put(int key, int value) {
        var n = _get(key);
        if (n != null) {
            n.val = value;
            return;
        }
        
        if (map.size() >= cap) {
            map.remove(Integer.valueOf(tail.key));
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        }
        
        
        var node = new Node(key, value);
        node.next = head;
        if (head != null) head.prev = node;
        else tail = node;
        head = node;
        map.put(Integer.valueOf(key), node);
    }
}
