class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> lt1 = new ArrayList<>();
        ArrayList<Integer> lt2 = new ArrayList<>();
        getLeafNodes(root1, lt1);
        getLeafNodes(root2, lt2);

        if (lt1.size() != lt2.size()) {
            return false;
        }

        for (int i = 0; i < lt1.size(); i++) {
            if (!lt1.get(i).equals(lt2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void getLeafNodes(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        getLeafNodes(node.left, list);
        getLeafNodes(node.right, list);
    }
}
