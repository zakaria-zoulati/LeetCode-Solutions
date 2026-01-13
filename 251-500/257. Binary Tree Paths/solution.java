class Solution {
    public void fill(List<String> rs, TreeNode root, StringBuilder curr) {
        curr.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            rs.add(curr.toString().substring(2));
            return;
        }
        if (root.left != null) {
            fill(rs, root.left, new StringBuilder(curr));
        }
        if (root.right != null) {
            fill(rs, root.right, new StringBuilder(curr));
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        fill(rs, root, curr);
        return rs;
    }
}