class Solution {
    public long maximumMedianSum(int[] nums) {
        long rs = 0 ; 
        int n = nums.length ; 
        Arrays.sort( nums ) ;
        int count = 0 ;
        for( int i=n-2 ; i>=0 && count < n/3 ; i-=2 ){
            rs += nums[i] ; 
            count++ ; 
        }
        return  rs ; 
    }
}