public class KthSmallestBST {
// this maps the ith smallest number to the node value.
    Map<Integer, Integer> map = new HashMap<>();
	
    public int kthSmallest(TreeNode root, int k) {
		// count is used to indicate the ith smallest number 
        Count c = new Count();
		
		// we call this method to populate the map.
        explore(c, root);
		// we get the kth smallest number from the map. 
        return map.get(k);
    }
    
    private void explore(Count count, TreeNode node) {
        if(node == null) {
            return;
        }
		// we get to the left most end before incrementing the count. 
        explore(count, node.left);
		
		// after the left node has been processed and count added to map,
		// we increment the count.
        count.count += 1;
		
		// this new count is then used for the present node. 
        map.put(count.count, node.val);
		
		// we then go to the right child. 
        explore(count, node.right);
    }
}

// Wrapper class to preserve the value of count at each call.
// The value remains the same because Java is call by reference and the
// same object is passed around at every call. 
private class Count {
    int count = 0;
}
