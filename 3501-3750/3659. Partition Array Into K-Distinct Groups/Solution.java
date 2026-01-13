class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length ; 
        if( n % k != 0 ) return false ; 
        int[] f = new int[100_001] ; 
        for( int i : nums ){
            f[i]++ ; 
        }
        int m = 0;  
        for( int i : f ){
            m = Math.max( m , i ) ; 
        }
        if( m > n / k ) return false ; 
        return true ; 
    }
}