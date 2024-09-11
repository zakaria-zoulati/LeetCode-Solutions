class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Thread thread1 = new Thread(() -> fill(list1, root1));
        Thread thread2 = new Thread(() -> fill(list2, root2));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;
    }
    private void fill(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        fill(list, root.left);
        list.add(root.val);
        fill(list, root.right);
    }
}