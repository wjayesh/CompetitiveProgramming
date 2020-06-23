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
class CountTreeNodes23 {
    int c = 0;
    public int countNodes(TreeNode root) {
        count(root);
        return c;
    }
    
    private void count(TreeNode root) {
        if(root == null) {
            return;
        }
        c++;
        count(root.left);
        count(root.right);
    }
}
