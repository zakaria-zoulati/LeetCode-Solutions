class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> rs = new ArrayList<>();
        if (root == null) return rs;
        postorderTraversal(root, rs);
        return rs;
    }
    public void postorderTraversal(Node node, List<Integer> rs) {
        if (node == null) return;
        for (Node child : node.children) {
            postorderTraversal(child, rs);
        }
        rs.add(node.val);
    }
}
