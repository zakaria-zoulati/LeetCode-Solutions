class Solution {
    public int maxProduct(int n) {
        if( n < 10 ){
            return 0 ; 
        }
        int[] f = new int[10] ; 
        while( n > 0 ){
            f[ n % 10 ]++ ; 
            n /= 10 ; 
        } 
        int a = 0 ; 
        int b = 0 ; 
        f[0]++ ; 
        for( int i=9 ; i>=0 ;  ){
            if( f[i] == 0 ) {
                --i ; 
            }else if( a == 0 ){
                a = i ; 
                f[i]-- ; 
            }else if( b == 0 ){
                b = i ; 
                f[i]-- ; 
            }else break ; 
        }
        return a*b ; 
    }
}