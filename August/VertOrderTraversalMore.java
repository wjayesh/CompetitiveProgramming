
class VertOrderTraversalMore {
    Map<Integer, TreeSet<int[]>> map = new TreeMap<>(); 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>(); 
        populate(root, 0, 0);
        for (int i : map.keySet()) { 
            List<Integer> list = new LinkedList<>();
            for (int[] j : map.get(i)) 
                list.add(j[0]); 
                
            res.add(list); 
        }
        return res; 
    }
    
    private void populate(TreeNode root, int order, int level) {
        if (root == null) return; 
        if (!map.containsKey(order)) 
            map.put(order, new TreeSet<int[]>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
        
        map.get(order).add(new int[]{root.val, level}); 
        populate(root.left, order - 1, level + 1); 
        populate(root.right, order + 1, level + 1); 
    }
}

// if level is gt than print that. otherwise compare values.
