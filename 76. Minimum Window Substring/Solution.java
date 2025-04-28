class Solution {
    public boolean check( int[] f  ){
        for( int i=0 ; i<26 ; ++i ){
            if( f[i+65] > 0 || f[i+97] > 0 ) return false ; 
        }
        return true ; 
    }
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
        for( int i=0 ; i<n ; ++i ){
            f[ chars[i] ]-- ; 
            if( check( f ) ){
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