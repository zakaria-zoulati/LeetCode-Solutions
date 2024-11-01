class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        if( n == 0  ) return true ; 
        int m = f.length ; 
        if( m == 1 ){
            return f[0] == 0 ; 
        }
        int co = 0 ;
        for( int i=0 ; i<m ; ++i ){
            if( i==0  ){
                if( f[0] + f[1] == 0 ){                 
                    ++co ; 
                    ++i ; 
                }
            }else if( i == m-1 ){
                if( f[m-1] + f[m-2] == 0 ){
                    ++co ; 
                    ++i ; 
                }
            }else {
                if( f[i] + f[i-1] + f[i+1] == 0 ){
                    ++co ; 
                    ++i ; 
                }
            }
        }
        return co >= n ; 
    }
}