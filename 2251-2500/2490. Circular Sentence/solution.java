class Solution {
    public boolean isCircularSentence(String s) {
        int n = s.length() ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) == ' ' && s.charAt( i+1 ) != s.charAt(i-1)) return false  ; 
        }
        return s.charAt(0) == s.charAt(n-1) ; 
    }
}