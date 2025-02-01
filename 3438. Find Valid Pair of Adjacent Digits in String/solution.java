class Solution {
    public String findValidPair(String s) {
        int n = s.length() ; 
        int[] f = new int[10] ; 
        for( char c : s.toCharArray() ){
            f[ c - '0' ]++ ; 
        }
        for( int i=0; i<n-1 ; ++i ){
            int c1 = s.charAt(i) - '0' ; 
            int c2 = s.charAt(i+1) - '0' ;
            if( c1 != c2 && f[c1] == c1 && f[c2] == c2 ){
                return s.substring( i , i+2 ) ; 
            }
        }
        return "" ; 
    }
}