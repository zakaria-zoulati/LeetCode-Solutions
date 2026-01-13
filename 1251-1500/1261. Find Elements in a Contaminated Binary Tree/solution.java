/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    TreeNode root ; 
    HashSet<Integer> set ;  
    public FindElements(TreeNode root) {
        set = new HashSet<>() ; 
        set.add(0) ; 
        this.root = root ; 
        this.root.val = 0 ; 
        recovers( root ) ; 
        
    }
    public boolean find(int target) {
        return set.contains( target ) ; 
    }

    public void recovers( TreeNode root ){
        if( root.right != null ){
            set.add(  2*root.val + 2 ) ; 
            root.right.val = 2*root.val + 2 ; 
            recovers( root.right ) ; 
        }
        if( root.left != null ){
            set.add( 2*root.val + 1 ) ; 
            root.left.val = 2*root.val + 1 ; 
            recovers( root.left ) ; 
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */