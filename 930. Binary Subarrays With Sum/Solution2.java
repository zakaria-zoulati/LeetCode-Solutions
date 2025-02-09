class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int start = 0, currentSum = 0, result = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            
            while (currentSum > goal && start <= end) {
                currentSum -= nums[start];
                start++;
            }
            
            result += end - start + 1;
        }
        return result;
    }
}