class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length() ; 
        int m = spaces.length ; 
        char[] chars = new char[n+m] ;  
        int p = 0 ; 
        int c = 0 ;
        for( int i=0; i<n ; ++i ){
            if( c<m && spaces[c] == i ){ 
                chars[p++] = ' ' ; 
                ++c ; 
            }
            chars[p++] = s.charAt(i) ;
        }
        return new String( chars ) ; 
    }
}