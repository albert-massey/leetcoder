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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if(start > end) return null;
        // if(idx > end) return null; 
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx+1, end);
        return root;
    }
}


// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         //base
//         if(preorder == null || preorder.length == 0) return null;
        
//         //logic
//         int rootIdx = -1;
//         TreeNode root = new TreeNode(preorder[0]);
        
//         for(int i = 0; i < inorder.length; i++) {
//             if(inorder[i] == preorder[0]) {
//                 rootIdx = i;
//             }
//         }
        
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
//         int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);

//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);
//         return root;
//     }
// }