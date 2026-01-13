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
    void trav(Node root, int level, List<List<Integer>> list){
        if(root == null) return;
        if(level == list.size()){
            list.add(new ArrayList<>(Arrays.asList(root.val)));
        }
        else 
            list.get(level).add(root.val);
        for(Node n : root.children)
            trav(n , level + 1 , list);
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        trav(root,0,list);
        return list;
    }
}