class Solution {
    public int maxLevelSum(TreeNode root) {
        int rs = 1;
        int m = 1;
        int curr = Integer.MIN_VALUE;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            int sum = 0;
            for (int i = 0; i < len; ++i) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (sum > curr) {
                rs = m;
                curr = sum;
            }
            ++m;
        }
        return rs;
    }
}
