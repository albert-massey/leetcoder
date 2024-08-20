class MyHashMap {
    /*
        0 1 2 3 4
        o U U U U
        o o o o o
        o o o o o 
        o o o o o
    */
    
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node[] storage;
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    
    private Node find(Node node, int key) {
        Node curr = node;
        Node prev = null;
        while(curr != null && curr.key != key) {
            prev= curr;
            curr = curr.next;
        }
        return prev;
    }
    
    private int hash(int key) {
        return key % storage.length;
    }
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }
        Node prev = find(storage[idx], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return -1;
        Node prev = find(storage[idx], key);
        if(prev.next == null) return  -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return;
        Node prev = find(storage[idx], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
        

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */