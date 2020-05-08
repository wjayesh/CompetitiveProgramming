package May;

import utils.TreeNode;

public class CousinsBT7 {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        findDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    public void findDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        } else {     
        findDepthAndParent(root.left, x, y, depth + 1, root);
        findDepthAndParent(root.right, x, y, depth + 1, root); }
    }
}