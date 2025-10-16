class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length ; 
        if( value == 1 ) return n ; 
        int[] f = new int[value] ; 
        for( int num : nums ){
            f[(num%value+value)%value]++ ; 
        }
        int m = Integer.MAX_VALUE ; 
        for( int i : f ) m = Math.min( m , i ) ; 
        for( int i=0 ; i<value ; ++i ){
            if( f[i] == m ){
                return m*value + i  ;
            }
        }
        return n ; 
    }
}