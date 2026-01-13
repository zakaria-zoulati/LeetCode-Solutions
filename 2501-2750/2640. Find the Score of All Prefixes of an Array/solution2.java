class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length ; 
        long[] rs = new long[n] ; 
        rs[0] =2*nums[0] ; 
        int max=nums[0] ; 
        for(int i=1;i<n;++i){
            if( nums[i] > max ) max = nums[i] ;
            rs[i] += (long) rs[i-1] + nums[i] + max ;
        }
        return rs ; 
    }
}