class Solution {
    int n;
    int[] nums;
    int[][] gcdMemo; 
    int[] memo;    

    public int maxScore(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.gcdMemo = new int[n][n];  
        this.memo = new int[1 << n];  

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                gcdMemo[i][j] = gcd(nums[i], nums[j]); 
                gcdMemo[j][i] = gcdMemo[i][j] ; 
            }
        }

        return backtrack(0, 1);
    }

    private int backtrack(int bitmask, int operation) {
        if (bitmask == (1 << n) - 1) {
            return 0;
        }

        if (memo[bitmask] != 0) {
            return memo[bitmask];
        }

        int maxScore = 0;

        for (int i = 0; i < n; ++i) {
            if ((bitmask & (1 << i)) != 0) continue;  

            for (int j = i + 1; j < n; ++j) {
                if ((bitmask & (1 << j)) != 0) continue; 

                int newBitmask = bitmask | (1 << i) | (1 << j);
                int currScore = operation * gcdMemo[i][j] + backtrack(newBitmask, operation + 1);

                maxScore = Math.max(maxScore, currScore);
            }
        }

        memo[bitmask] = maxScore;
        return maxScore;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
