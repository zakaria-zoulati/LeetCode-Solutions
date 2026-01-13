class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int rs = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < n ; ++i) {
            if (nums[i] == target) {
                rs = Math.min(rs, i + 1);
            } else if (target < nums[i]) {
                int pos = Arrays.binarySearch(nums, nums[i] - target);
                if (pos >= 0) {
                    rs = Math.min(rs, i - pos);
                } else {
                    pos = -(pos + 1);
                    if( pos==0 ){
                        rs = Math.min(rs , i+1) ; 
                    }else {
                        rs = Math.min( rs , i-pos+1 ) ; 
                    }
                }
            }
        }
        return rs == Integer.MAX_VALUE ? 0 : rs;
    }
}
