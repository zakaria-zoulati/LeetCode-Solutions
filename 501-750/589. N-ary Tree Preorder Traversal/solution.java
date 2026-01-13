/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void fill( List<Integer> rs , Node root ){
        if( root == null ) return ; 
        rs.add( root.val ) ; 
        for( Node node : root.children ){ 
            fill( rs , node ) ; 
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> rs = new ArrayList<>() ;
        fill(rs , root) ; 
        return rs ; 
    }
}