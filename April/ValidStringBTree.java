package April;
import April.utils.TreeNode;

public class ValidStringBTree {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int index = 0;
        return isValid(root, arr, index);
    }

    private boolean isValid(TreeNode root, int[] arr, int index) {
        if(index == arr.length) {
            return false;
        }
        if(root.left == null && root.right == null && index == arr.length - 1 && root.val == arr[index]) {
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