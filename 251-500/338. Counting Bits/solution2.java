class Solution {
    public int[] countBits(int n) {
        int[] rs = new int[n+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            if( (i&1) == 1 ){
                rs[i] = rs[i-1] + 1 ; 
            }else {
               rs[i] = rs[i/2] ; 
            }
        }
        return rs ; 
    }
}