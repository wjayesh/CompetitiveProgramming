
import utils.TreeNode;
 
class Height 
{ 
    int h; 
} 
  
/* Class to print the Diameter */
class DiameterBTDay11 
{ 
  
    /* define height =0 globally and  call diameterOpt(root,height) 
       from main */
    int diameterOpt(TreeNode root, Height height) 
    { 
        /* lh --> Height of left subtree 
           rh --> Height of right subtree */
        Height lh = new Height(), rh = new Height(); 
  
        if (root == null) 
        { 
            height.h = 0; 
            return 0; /* diameter is also 0 */
        } 
          
        /* ldiameter  --> diameter of left subtree 
           rdiameter  --> Diameter of right subtree */  
        /* Get the heights of left and right subtrees in lh and rh 
         And store the returned values in ldiameter and rdiameter */
        int ldiameter = diameterOpt(root.left, lh); 
        int rdiameter = diameterOpt(root.right, rh); 
  
        /* Height of current node is max of heights of left and 
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1; 
  
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter)); 
    } 
  
    /* A wrapper over diameter(Node root) */
    int diameterOfBinaryTree(TreeNode root) 
    { 
        Height height = new Height(); 
        return diameterOpt(root, height); 
    } 
}





