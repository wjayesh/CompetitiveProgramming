import utils.TreeNode;

public class BSTfromPreDay20 {
    Index index = new Index();
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTreeUtil(preorder, index, preorder[0], 
                    Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.length);
    }
    
    TreeNode constructTreeUtil(int pre[], Index preIndex, int key, 
            int min, int max, int size) { 
  
        // Base case 
        if (preIndex.index >= size) { 
            return null; 
        } 
  
        TreeNode root = null; 
  
        // If current element of pre[] is in range, then 
        // only it is part of current subtree 
        if (key > min && key < max) { 
  
            // Allocate memory for root of this  
            // subtree and increment *preIndex 
            root = new TreeNode(key); 
            preIndex.index = preIndex.index + 1; 
  
            if (preIndex.index < size) { 
  
                // Construct the subtree under root 
                // All TreeNodes which are in range {min .. key}  
                // will go in left subtree, and first such  
                // TreeNode will be root of left subtree. 
                root.left = constructTreeUtil(pre, preIndex,  
                            pre[preIndex.index], min, key, size); 
  
                // All TreeNodes which are in range {key..max}  
                // will go in right subtree, and first such 
                // TreeNode will be root of right subtree.
                if (preIndex.index < size) {
                    root.right = constructTreeUtil(pre, preIndex,  
                             pre[preIndex.index], key, max, size); 
                }
                
            } 
        } 
  
        return root; 
    }

    public static void main(String[] args) {
        BSTfromPreDay20 obj = new BSTfromPreDay20();
        System.out.println(obj.bstFromPreorder(new int[]{4, 2}));
    }
    
}

class Index {
int index = 0;
}