package leetcodeJava;

class MyLinkedList {
    
    class Node {
        int val;
        Node next;
        public Node(int v) {
            val = v;
        }
    }
    
    Node dummyHead;
    Node tail;
    int len;

    public MyLinkedList() {
        dummyHead = new Node(0);
        tail = dummyHead;
        len = 0;
    }
    
    public int get(int index) {
        if (index >= len || index < 0) return -1;
        var ptr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.val;
    }
    
    public void addAtHead(int val) {
        var node = new Node(val);
        node.next = dummyHead.next;
        if(dummyHead.next == null) tail = node;
        dummyHead.next = node;
        len++;
    }
    
    public void addAtTail(int val) {
        var node = new Node(val);
        tail.next = node;
        tail = node;
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > len || index < 0) return;
        var node = new Node(val);
        var ptr = dummyHead;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        node.next = ptr.next;
        ptr.next = node;
        len++;
        if (node.next == null) tail = node;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        var ptr = dummyHead;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        var next = ptr.next.next;
        ptr.next = next;
        len--;
        if (ptr.next == null) tail = ptr;
    }
}
