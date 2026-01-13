class Solution {
    boolean[] f = new boolean[366] ; 
    private int solve(int[] dp, int[] days, int[] costs, int curr) {
        if (curr > days[days.length - 1]) {
            return 0;
        }
        if (!f[curr]) {
            return solve(dp, days, costs, curr + 1);
        }
        if (dp[curr] != 0 ) {
            return dp[curr];
        }
        int a = costs[0] + solve(dp, days, costs, curr + 1);
        int b = costs[1] + solve(dp, days, costs, curr + 7);
        int c = costs[2] + solve(dp, days, costs, curr + 30);
        return dp[curr] = Math.min(a, Math.min(b, c));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        for (int d : days) {
            f[d] = true ;  
        }
        return solve(dp, days, costs, 1);
    }
}