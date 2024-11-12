class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length ; 
        long[] rs = new long[n] ; 
        rs[0] = 2*nums[0] ; 
        int max = nums[0] ; 
        for(int i=1 ;i<n ; ++i){
            max = Math.max( nums[i] , max ) ; 
            rs[i] += rs[i-1] ;
            rs[i] += nums[i] ; 
            rs[i] += max ; 
        }
        return rs ; 
    }
}