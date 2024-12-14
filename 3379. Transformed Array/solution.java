class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] > 0 ){
                rs[i] = nums[ ( i+nums[i] )%n ] ; 
            }else if( nums[i] < 0 ){
                rs[i] = nums[  (i + nums[i] + 100*n) %n ] ; 
            }
        }
        return rs ; 
    }
}