class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int rs = Math.abs(nums[0]);
        for (int i = 1; i < n; ++i) {
            if (min + nums[i] < nums[i]) {
                min +=nums[i] ;
            }else {
                min = nums[i];
            }
            if (max + nums[i] > nums[i]) {
                max += nums[i];
            } else {
                max = nums[i];
            }
            int best = (Math.abs(max) > Math.abs(min)) ? Math.abs(max) : Math.abs(min);
            if (best > rs) {
                rs = best;
            }
        }
        return rs;
    }
}
