class Solution {
    int mod = 1_000_000_007 ;
    public int lengthAfterTransformations(String s, int t) {
        int[] f = new int[26] ; 
        for( char c : s.toCharArray() ){
            f[ c - 'a' ]++ ; 
        }
        int in = 0 ; 
        while( t-- > 0 ){
            int b = in ; 
            in = (in +25)%26 ; 
            f[b] = (f[b] + f[in] ) % mod ; 
        }
        int rs = 0 ; 
        for( int i : f ){
            rs = ( rs + i ) % mod ;
        }
        return rs ; 
    }
}