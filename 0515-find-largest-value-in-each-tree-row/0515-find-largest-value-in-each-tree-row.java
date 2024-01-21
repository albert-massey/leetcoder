/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return result;
        bfs(root);
        return result;
    }
    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        result.add(root.val);
        while(!q.isEmpty()) {
            int size = q.size();
            // int max = Integer.MIN_VALUE;
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                    // max = Math.max(max, curr.left.val);
                    temp.add(curr.left.val);
                }                
                if(curr.right != null) {
                    q.add(curr.right);
                    // max = Math.max(max, curr.right.val);
                    temp.add(curr.right.val);
                }
            }
            if (!temp.isEmpty()) {  
                int curr = temp.get(0);
                for (int i = 1; i < temp.size(); i++) {
                    curr = Math.max(curr, temp.get(i));
                }
                result.add(curr);
            }
            // if(max != Integer.MIN_VALUE){
            //     result.add(max);
            // }
            // max = Integer.MIN_VALUE();
        }
    }
}