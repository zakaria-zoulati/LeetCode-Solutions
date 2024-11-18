class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length  ;
        int[] rs = new int[n] ; 
        if( k == 0 ){
            return rs ; 
        }else if( k > 0 ){
            int f = 0 ; 
            for( int i=1 ; i<=k ; ++i ){
                f += code[i] ; 
            }
            rs[0] = f ; 
            for( int i=1 ; i<n ; ++i ){
                f -= code[i] ; 
                f += code[ (i+k) %n ] ; 
                rs[i] = f ;
            }
        }else {
            int p = 0 ; 
            for( int i=n+k; i<n ; ++i ){
                p += code[i] ; 
            }
            rs[0] = p ; 
            for( int i=1 ; i<n ; ++i ){
                p += code[i-1] ; 
                p -= code[( n + k + i - 1  ) % n ] ; 
                rs[i] = p ; 
            }
        }
        return rs ; 
    }
}