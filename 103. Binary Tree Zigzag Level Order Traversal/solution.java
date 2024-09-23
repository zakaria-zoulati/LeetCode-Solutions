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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>() ; 
        if( root == null ){
            return list ; 
        }
        boolean flag = false ; 
        Queue<TreeNode> q = new LinkedList<>() ;
        q.add(root) ; 
        while( !q.isEmpty() ){
            List<Integer> curr = new ArrayList<>() ; 
            int size = q.size() ; 
            while( size-->0 ){
                TreeNode inter = q.poll() ; 
                curr.add( inter.val ) ; 
                if( inter.left != null ){
                    q.add( inter.left ) ; 
                } 
                if( inter.right != null ){
                    q.add( inter.right ) ; 
                }
            }
            if( flag ){
                Collections.reverse( curr ) ; 
            }
            list.add( curr ) ; 
            flag = !flag ; 
        }

        return list ; 

    }
}