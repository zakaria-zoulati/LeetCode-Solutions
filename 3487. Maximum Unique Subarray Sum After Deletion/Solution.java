class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length ; 
        int[] f = new int[201] ; 
        for( int i : nums ){
            f[ i + 100 ]++ ; 
        }
        int rs = 0 ; 
        for( int i=200 ; i>100 ; --i ){
            if( f[i] > 0 ){
                rs += i-100 ; 
            }
        }
        if( rs > 0 ) return rs ; 
        for( int i=100 ; i>=0 ; --i ){
            if( f[i] > 0 ){
                return i-100 ; 
            } 
        }
        return -1 ; 
    }
}