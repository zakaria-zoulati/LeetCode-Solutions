class Solution {
    public String minWindow(String s, String t) {
        int n = s.length() ; 
        int m = t.length() ; 
        if( m > n ) return "" ; 
        char[] chars = s.toCharArray() ; 
        int[] f = new int[127] ;
        for( char c : t.toCharArray() ) ++f[c]  ;
        int start = 0 ; 
        int len = Integer.MAX_VALUE ; 
        int rs = -1 ; 
        int required = 0 ;
        for( int i : f ) {
            if( i > 0 ) ++required ; 
        } 
        for( int i=0 ; i<n ; ++i ){
            if( --f[chars[i]] == 0 ) required-- ; 
            if( required == 0  ){
                while( f[ chars[start] ] < 0 ){
                    f[ chars[start++] ]++ ; 
                }
                if( i - start + 1 < len ){
                    len = i - start + 1; 
                    rs = start ; 
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring( rs , len+rs ) ;   
    }
}