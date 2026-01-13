class Solution {
    int rs = Integer.MAX_VALUE;

    public int closestCost(int[] bases, int[] t, int target) {
        for (int b : bases) {
            dfs(t, target, b, 0);
        }
        return rs;
    }
    public void dfs(int[] t, int target, int curr, int index) {
        if (Math.abs(curr - target) < Math.abs(rs - target) || 
            (Math.abs(curr - target) == Math.abs(rs - target) && curr < rs)) {
            rs = curr;
        }
        if (index >= t.length || curr > target) {
            return;
        }
        dfs(t, target, curr, index + 1);
        dfs(t, target, curr + t[index], index + 1);
        dfs(t, target, curr + 2 * t[index], index + 1);
    }
}
