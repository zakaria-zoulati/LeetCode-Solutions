// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int val) { this.val = val; }
// }

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();
        while (i < n) {
            int depth = 0, num = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            while (i < n && traversal.charAt(i) != '-' ) {
                num = num * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(num);
            while (stack.size() > depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
