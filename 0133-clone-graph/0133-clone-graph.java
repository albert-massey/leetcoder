/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        // Node newNode = 
        // map.put()
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(!map.containsKey(curr)) {
                Node nodeCopy = new Node(curr.val);
                map.put(curr, nodeCopy);
            }
            for(Node ne: curr.neighbors) {
                if(!map.containsKey(ne)) {
                    Node copy = new Node(ne.val);
                    map.put(ne, copy);
                    q.add(ne);
                }
                map.get(curr).neighbors.add(map.get(ne));
            }
        }
        return map.get(node);
    }
}