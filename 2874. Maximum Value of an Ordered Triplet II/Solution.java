class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length ; 
        long rs = 0L ; 
        long maxDiff = 0L ; 
        long maxNum = 0L ; 
        for( int num : nums ){
            rs = Math.max( rs , maxDiff*num ) ; 
            maxNum = Math.max( maxNum , num ) ; 
            maxDiff = Math.max( maxDiff , maxNum - num ) ; 
        }
        return rs>0 ? rs : 0L ; 
    }
}