class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length ; 
        int rs = Integer.MAX_VALUE ; 
        boolean flag = true ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] != i ){
                rs &= nums[i] ;
                flag = false;  
            }
        }
        if( flag ) return 0 ; 
        return rs ;
    }
}