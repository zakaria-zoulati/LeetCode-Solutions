class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        };
        if (target > sum || target + sum < 0 || (target+sum)%2 != 0) {
            return 0;
        }
        int targetSum = (target + sum)/2;
        dp = new int[targetSum+1]; 
        dp[0] = 1 ; 
        countSubsets( nums , 0 , targetSum ) ; 
        return dp[targetSum] ;
    }
    public void countSubsets(int[] nums, int index, int targetSum ) {
        if (index == nums.length) {
            return;
        }
        for( int j=targetSum ; j>=nums[index] ; j-- ){
            dp[j] += dp[j-nums[index]] ;
        }
        countSubsets(nums, index+1, targetSum);
    }
}