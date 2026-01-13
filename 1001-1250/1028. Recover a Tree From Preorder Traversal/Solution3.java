class Solution {
    int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, 0);
    }
    private TreeNode dfs(String s, int depth) {
        if (index >= s.length()) return null;
        int count = 0;
        while (index + count < s.length() && s.charAt(index + count) == '-') {
            count++;
        }
        if (count != depth) return null;
        index += count;
        int num = 0;
        while (index < s.length() && s.charAt(index) != '-') {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }
        TreeNode node = new TreeNode(num);
        node.left = dfs(s, depth + 1);
        node.right = dfs(s, depth + 1);
        return node;
    }
}