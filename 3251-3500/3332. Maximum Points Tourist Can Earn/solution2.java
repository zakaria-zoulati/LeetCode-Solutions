class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
    int[] dp = new int[n];
    for (int i = 0; i < k; ++i) {
        int[] dp2 = dp.clone();
        for (int curr = 0; curr < n; ++curr)
            dp2[curr] += stayScore[i][curr];
        for (int curr = 0; curr < n; ++curr)
            for (int dest = 0; dest < n; ++dest)
                dp2[dest] = Math.max(dp2[dest], dp[curr] + travelScore[curr][dest]);
        dp = dp2;
    }
    int rs = 0 ; 
    for(int i:dp){
        rs = Math.max( rs , i ) ; 
    }
    return rs ; 
}
}