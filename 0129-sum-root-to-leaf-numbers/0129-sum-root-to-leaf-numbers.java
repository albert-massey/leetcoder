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
// class Solution {
//     public int sumNumbers(TreeNode root) {
//         int sum = 0;
//         int currNum = root.val;
//         helper(root, sum, currNum);
//         return sum;
//     }
    
//     private int helper(TreeNode root, int sum, int currNum) {
//         //base
//         if(root == null) return 0;
        
//         //logic
//         helper(root.left, sum, currNum);
        
//         helper(root.right, sum, currNum);
        
        
//     }
// }
class Solution {
    int globalSum = 0;
    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return globalSum;
    }
    private void inorder(TreeNode root, int currNum) {
        //base 
        if(root == null) return;

        //logic
        currNum = currNum * 10 + root.val;
        inorder(root.left, currNum);
        if(root.left == null && root.right == null) {
            globalSum += currNum;
        }
        inorder(root.right, currNum);
    }
}