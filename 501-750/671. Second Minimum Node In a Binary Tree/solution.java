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
    public void fill( TreeNode root , HashMap<Integer,Integer> map ){
        if( root == null ) return ;
        map.put( root.val , map.getOrDefault( root.val , 0  ) + 1 ) ; 
        fill( root.right , map ) ;
        fill( root.left  , map ) ;
    }
    public int findSecondMinimumValue(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        fill( root , map  ) ; 
        if( map.keySet().size() == 1 ) return -1  ;
        int s1 = Integer.MAX_VALUE ; 
        int s2 = Integer.MAX_VALUE ; 
        for( int key : map.keySet() ){
            if( key < s1 ){
                s2 = Math.min(s1 , s2) ; 
                s1 = key ; 
            }else if( key < s2 ){
                s2 = key ; 
            }
        }
        return s2 ; 
    }
}