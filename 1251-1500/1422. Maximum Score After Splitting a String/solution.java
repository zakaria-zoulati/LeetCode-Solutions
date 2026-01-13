class Solution {
    public int maxScore(String s) {
        int n = s.length() ; 
        int ones = 0 ;
        for( char c : s.toCharArray() ){
            ones += c-'0' ; 
        }
        int zeros = 0 ; 
        int rs = 0 ; 
        for( int i=0; i<n-1 ; ++i ){
            int curr = s.charAt(i) - '0' ; 
            ones -= curr ; 
            zeros += 1 - curr ;
            rs = Math.max( ones+zeros , rs ) ; 
        }
        return rs ; 
    }
}