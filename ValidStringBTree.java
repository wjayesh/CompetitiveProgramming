import utils.TreeNode;

public class ValidStringBTree {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int index = 0;
        return isValid(root, arr, index);
    }

    private boolean isValid(TreeNode root, int[] arr, int index) {
        if(index == arr.length) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.val != arr[index]) {
            return false;
        } else {
            index++;
            if(isValid(root.left, arr, index) || isValid(root.right, arr, index)) {
                return true;
            }
        }
        return false;
    }
}