class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length() ;
        int ones = 0 ;
        for( char c : s.toCharArray() ){
            if( c == '1' ) ones++ ;
        }
        int zeros = n - ones  ; 
        int rs = zeros ; 
        int curr = zeros ; 
        for( char c : s.toCharArray() ){
            if( c == '1' ){
                curr++ ; 
            }else {
                curr-- ; 
            }
            rs = Math.min( rs , curr ) ; 
        }
        return rs ; 
    }
}