class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEvenLevel = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prevValue = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;   
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (isEvenLevel) {
                    if (node.val % 2 == 0 || node.val <= prevValue) return false;
                } else {
                    if (node.val % 2 == 1 || node.val >= prevValue) return false;
                }
                prevValue = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            isEvenLevel = !isEvenLevel;
        }
        return true;
    }
}
