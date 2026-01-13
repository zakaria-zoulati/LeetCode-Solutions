class Solution {
    public int[] countBits(int n) {
        int[] rs = new int[n+1] ; 
        for( int i=1 ; i<=n ; ++i ){
            if( i%2 == 1 ){
                rs[i] = rs[i-1] + 1 ; 
            }else {
                int count = 0 ; 
                int cu = i ; 
                while( cu%2 == 0 ){
                    count++ ; 
                    cu >>= 1;
                }
                rs[i] = rs[i-1] - count + 1 ;
            }
        }
        return rs ; 
    }
}