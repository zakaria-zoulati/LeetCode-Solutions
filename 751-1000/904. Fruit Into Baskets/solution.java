class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length ; 
        int rs = 0 ; 
        int s = fruits[0] ; 
        int c1 = 1 ; 
        int i=1;
        for(  ; i<n ; ++i ){
            if( fruits[i] == s ){
                ++c1 ;  
            }else {
                break ;
            }
        }
        if( i == n ) return c1 ; 
        int e = fruits[i] ; 
        int c2 = 1 ; 
        while( i+1 < n && fruits[i+1] == e ){
            ++c2 ; 
            ++i ; 
        }
        int p1 = 0 ; 
        int p2 = c2 ; 
        ++i ; 
        for( ; i<n ; ++i ){
            if( fruits[i] == s ){
                p1 = 1 ;
                while( i+1 < n && fruits[i+1] == s ){
                    ++p1 ; 
                    ++i ; 
                } 
                c1 += p1 ; 
            }else if( fruits[i] == e ){
                p2 = 1 ; 
                while( i+1<n && fruits[i+1] == e  ){
                    ++p2 ; 
                    ++i ; 
                }
                c2 += p2 ; 
            }else {
                rs = Math.max( c1 + c2 , rs ) ; 
                if( fruits[i-1] == e ){
                    s = e ; 
                    c1 = p2 ; 
                }else {
                    c1 = p1 ; 
                }
                e = fruits[i] ;  
                p2 = 1 ; 
                while( i+1< n && fruits[i+1] == e ){
                    ++p2 ; 
                    ++i ; 
                }
                c2 = p2 ; 
            }
        }
        rs = Math.max( rs , c1 + c2 ) ; 
        return rs ; 
    }
}