class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length ;
        int[] rs = new int[n] ; 
        int left = 0 ; 
        int right = 0 ; 
        for(int i=n-1 ; i>0 ; i--){
            right += nums[i] ;
        }
        for(int i=0 ; i<n ; ++i){
            rs[i] = Math.abs( right - left ) ; 
            left += nums[i] ; 
            if( i+1 < n ){
                 right -= nums[i+1] ; 
            }
        }
        return rs ;
    }
}