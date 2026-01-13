class Solution {
    public int partitionArray(int[] nums, int k) {
        int m = 0 ; 
        for( int i : nums ){
            if( i > m ) { 
                m = i ; 
            }
        }
        int[] f = new int[m+1] ; 
        for( int i :  nums ){
            f[i]++ ; 
        }
        int count = 1 ; 
        int i=0 ; 
        while(f[i] == 0) i++ ; 
        int prev = i ; 
        for( ; i<=m ; ++i ){
            if( f[i] == 0 ) continue ; 
            if( i - prev > k ){
                prev = i ; 
                count++ ; 
            }
        }
        return count ; 
    }
}