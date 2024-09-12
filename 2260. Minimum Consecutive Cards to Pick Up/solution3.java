class Solution {
    public int minimumCardPickup(int[] cards) {
        int max = 0;
        int n = cards.length;
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            if (cards[i] > max) {
                max = cards[i];
            }
        }
        int[] prev = new int[max + 2];
        for (int i = 0; i < n; i++) {
            int curr = cards[i];
            if (prev[curr] != 0) {
                res = Math.min(res, i + 1 - prev[curr] + 1);
            }
            prev[curr] = i + 1;
        }
        if (res == n + 1) {
            return -1;
        }
        return res;
    }
}