class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length ; 
        int rs = 0 ;
        int max = 0 ; 
        for(int i=0 ; i<n ; ++i){
            max = Math.max( nums[i] , max ) ; 
        }
        rs = k*(2*max+k-1)/2  ;
        return rs  ;
    }
}