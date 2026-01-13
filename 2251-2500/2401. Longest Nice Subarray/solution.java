class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int curr = 0;  
        int rs = 0;
        for (int right = 0; right < n; ++right) {
            while ((curr & nums[right]) != 0) {
                curr ^= nums[left];  
                left++;
            }
            curr |= nums[right];  
            rs = Math.max(rs, right - left + 1);
        }
        return rs;
    }
}
