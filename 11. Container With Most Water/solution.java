class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length; 
        int l = 0; 
        int r = n - 1; 
        int rs = 0; 
        while (l < r) {
            int cu = Math.min(nums[l], nums[r]) * (r - l);
            if( cu > rs ) rs = cu ; 
            if (nums[l] < nums[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return rs ;  
    }
}
