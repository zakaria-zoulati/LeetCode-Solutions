class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length ; 
        Arrays.sort(nums) ; 
        int rs = 0 ; 
        for(int i=0 ; i<n/2; ++i){
            rs = Math.max( rs , nums[i] + nums[n-1-i] ) ; 
        }
        return rs ; 
    }
}