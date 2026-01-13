class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length ; 
        long power = nums[0] ; 
        for(int i=1 ; i<n ; i++ ){
            if(power == 0 ){
                return false ; 
            }
            power-- ; 
            power = Math.max(power , nums[i]) ; 
        }
        return true ; 
    }
}