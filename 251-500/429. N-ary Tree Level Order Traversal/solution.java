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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rs = new ArrayList<>() ; 
        if( root == null  ){
            return rs ; 
        }
        Queue<Node> q  = new LinkedList<>() ; 
        q.add( root ) ; 
        while( !q.isEmpty() ){
            List<Integer> curr = new ArrayList<>() ; 
            int size = q.size() ; 
            while( size-- > 0 ){
                Node inter = q.poll() ; 
                curr.add( inter.val ) ; 
                for( Node n : inter.children ){
                    q.add(n) ; 
                }
            }
            rs.add( curr ) ; 
        }

        return rs ; 

    }
}