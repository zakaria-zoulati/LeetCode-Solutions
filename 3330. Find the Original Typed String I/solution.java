class Solution {
    public int possibleStringCount(String word) {
        int rs = 1 ; 
        int n = word.length() ; 
        int co = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            co = 0 ; 
            while( i+1<n && word.charAt(i+1)==word.charAt(i) ){
                ++co ; 
                ++i ; 
            }
            rs += co ;
        }
        return rs ; 
    }
}