class InvertBST1 {
    public TreeNode invertTree(TreeNode root) {
        invertUtil(root);
        return root;
    }
    
    private void invertUtil(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
    }
}
