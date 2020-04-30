import utils.TreeNode;

public class MaxPathSumDay29 {
    public int maxPathSum(TreeNode root) {
        return maxSum(root);
    }

    private int maxSum(TreeNode root) {
        if(root.left == null || root.right == null) {
            return root.val;
        }
        int sum = 0;
        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);
        sum = Math.max(leftSum + rightSum + root.val, root.val);   
        sum = Math.max(sum, Math.max(leftSum, rightSum) + root.val);
        return sum;
    }

}