class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int left = 1, right = 0;
        for (int quantity : q) {
            right = Math.max(right, quantity);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, q)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canDistribute(int maxPerGroup, int n, int[] q) {
        int groupsNeeded = 0;
        for (int quantity : q) {
            groupsNeeded += (quantity + maxPerGroup - 1) / maxPerGroup; 
            if (groupsNeeded > n) {
                return false;
            }
        }
        return groupsNeeded <= n;
    }
}
