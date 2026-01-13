class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int rs = 0;

        int[] helper = new int[n];
        helper[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; --i) {
            helper[i] = Math.max(events[i][2], helper[i + 1]);
        }

        for (int i = 0; i < n; ++i) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    right = mid; 
                } else {
                    left = mid + 1; 
                }
            }

            int curr = events[i][2];
            if (left < n) { 
                curr += helper[left];
            }
            rs = Math.max(rs, curr);
        }
        return rs;
    }
}
