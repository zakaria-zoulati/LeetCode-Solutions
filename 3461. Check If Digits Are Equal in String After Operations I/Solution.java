class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length() ; 
        if( n == 2 ){
             return s.charAt(0) == s.charAt(1) ;    
        }
        int[] curr = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            curr[i] = s.charAt(i) - '0' ;
        }
        
        for( int i=1 ; i<n-1 ; ++i ){
            int[] next = new int[n] ; 
            for( int j=0 ; j<n-i ; ++j ){
                next[j] = ( curr[j] + curr[j+1] ) % 10 ; 
            }
            curr = next ; 
        }

        return curr[0] == curr[1] ;
    }
}