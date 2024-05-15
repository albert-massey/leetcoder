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
    TreeNode prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }
    
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        
        
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
    
    
    
    // boolean flag = true;
    // TreeNode prev;
    // public boolean isValidBST(TreeNode root) {
    //     // inorder(root);
    //     // return flag;
    //     Stack<TreeNode> st = new Stack<>();
    //     TreeNode prev = null;
    //     while (!st.isEmpty() || root != null) {
    //         while(root != null) {
    //             st.push(root);
    //             root = root.left;
    //         }
    //         root = st.pop();
    //         if(prev != null && prev.val >= root.val) {
    //             return false;
    //         }
    //         prev = root;
    //         root = root.right;
    //     }
    //     return true;
    // }

//     private void inorder (TreeNode root) {
//         //base
//         if(root == null) return;

//         //logic 
//         inorder(root.left);
//         if (prev != null && prev.val >= root.val) {
//             flag = false;
//         }
//         prev = root;
//         inorder(root.right);
//     } 
}