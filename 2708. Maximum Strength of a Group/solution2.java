class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums); 
        long rs = 1L; 
        int l = 0; 
        int r = n - 1; 
        boolean f = false; 


        while (r >= 0 && nums[r] > 0) {
            rs *= nums[r--];  
            f = true;  
        }  
        while (l + 1 <= r && nums[l + 1] < 0) {
            rs *= nums[l++]; 
            rs *= nums[l++]; 
            f = true;
        }

        if (f) {
            return rs; 
        }
        return nums[r] == 0 ? 0 : nums[l]; 
    }
}
