class Solution {
    public int makeStringGood(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] cnt = new int[26];
        for (char c : str) {
            cnt[c - 'a']++;
        }
        int mn = n, mx = 0;
        for (int c : cnt) {
            if (c > 0) {
                mn = Math.min(mn, c);
                mx = Math.max(mx, c);
            }
        }
        if (mn == mx) {
            return 0;
        }
        int[][] dp = new int[26][2];
        int ans = n - 1;
        for (int i = mn; i <= mx; i++) {
            dp[0][0] = cnt[0];
            dp[0][1] = cnt[0] <= i ? i - cnt[0] : cnt[0] - i;
            for (int j = 1; j < 26; j++) {
                dp[j][0] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cnt[j];
                if (cnt[j] >= i) {
                    dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][1]) + (cnt[j] - i);
                } else {
                    dp[j][1] = Math.min(dp[j - 1][0] + i - Math.min(i, cnt[j] + cnt[j - 1]), dp[j - 1][1] + i - Math.min(i, cnt[j] + Math.max(0, cnt[j - 1] - i)));
                }
            }
            ans = Math.min(ans, Math.min(dp[25][0], dp[25][1]));
        }
        return ans;
    }
}