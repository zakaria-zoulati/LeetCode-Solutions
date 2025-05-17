class Solution {
    public String longestPrefix(String s) {
        int n = s.length() ; 
        char[] chars = s.toCharArray() ; 
        int[] z = new int[n] ; 
        int l = 0 ; 
        int r = 0 ; 
        for( int i=1 ; i<n ; ++i ){
            if( i<r ){
                z[i] = Math.min( r - i , z[i-l] ) ; 
            }
            while( i+z[i]<n && chars[z[i]] == chars[i +z[i] ]  ){
                z[i]++ ; 
            }
            if( i + z[i] > r ){
                l = i ; 
                r = i + z[i] ; 
            }
            if( z[i] + i == n ){
                return s.substring( i , i + z[i] ) ;  
            }
        }
        return "" ; 
    }
}