import utils.TreeNode;

public class MaxPathSumDay29 {
    public int maxPathSum(TreeNode root) {
        GlobalMax globalMax = new GlobalMax();
        globalMax.val = Integer.MIN_VALUE;
        maxSum(root, globalMax);
        return globalMax.val;
    }

    private int maxSum(TreeNode root, GlobalMax obj) {
        if(root.left == null || root.right == null) {
            return root.val;
        }
        int sum = 0;
        int leftSum = maxSum(root.left, obj);
        int rightSum = maxSum(root.right, obj);
        sum = Math.max(leftSum + rightSum + root.val, root.val);   
        sum = Math.max(sum, Math.max(leftSum, rightSum) + root.val);
        obj.val = Math.max(obj.val, sum);
        return sum;
    }

}
class GlobalMax {
    int val;
}