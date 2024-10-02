class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums) ; 
        int n = nums.length ; 
        int rs = 0 ; 
        int prev = nums[0]  ; 
        for(int i=1 ; i<n ; ++i){
            if( nums[i] > prev ){
                prev = nums[i] ; 
            }else {
                rs += nums[i-1] + 1 - nums[i] ; 
                nums[i] = nums[i-1]+1 ; 
                prev = nums[i] ; 
            }
        }
        return rs ; 
    }
}