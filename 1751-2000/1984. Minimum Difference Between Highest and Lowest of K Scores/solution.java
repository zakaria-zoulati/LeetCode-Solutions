class Solution {
    public int minimumDifference(int[] nums, int k) {
        if( k==1 ){
            return  0; 
        }
        Arrays.sort(nums) ; 
        int n = nums.length ; 
        int rs = Integer.MAX_VALUE ; 
        for(int i=n-1 ; i-k+1>=0 ; i--){
            rs = Math.min( rs ,  nums[i] - nums[i-k+1] ) ; 
        }
        return rs ;
    }
}