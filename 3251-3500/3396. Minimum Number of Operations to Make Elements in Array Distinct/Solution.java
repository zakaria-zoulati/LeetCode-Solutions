class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length ; 
        boolean[] f = new boolean[101] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            if( f[ nums[i] ] ){
                return (i+3)/3 ;
            }
            f[ nums[i] ] = true ; 
        }
        return 0 ; 
    }
}