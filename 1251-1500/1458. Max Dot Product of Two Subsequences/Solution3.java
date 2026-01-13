class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] dp = new int[m + 1];  
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = n - 1; i >= 0; --i) {
            int prev = Integer.MIN_VALUE; 
            for (int j = m - 1; j >= 0; --j) {
                int current = nums1[i] * nums2[j] + Math.max(0, prev); 
                prev = dp[j]; 
                dp[j] = Math.max(current, Math.max(dp[j], dp[j + 1])); 
            }
        }
        return dp[0]; 
    }
}