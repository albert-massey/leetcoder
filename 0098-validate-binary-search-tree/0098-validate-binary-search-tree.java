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
    boolean flag = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder (TreeNode root) {
        //base
        if(root == null) return;

        //logic 
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        inorder(root.right);
    } 
}