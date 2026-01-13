class Solution {

    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> rs = new ArrayList<>();

        if (n % 2 == 0) {
            return rs;
        }

        if (n == 1) {
            rs.add(new TreeNode(0));
            return rs;
        }

        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {
            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    rs.add(root);
                }
            }
        }
        memo.put(n, rs);
        return rs;
    }
}
