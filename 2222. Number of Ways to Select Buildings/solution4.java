class Solution {
    public long numberOfWays(String s) {
        int n = s.length() ; 
        long rs = 0L ; 
        int zeros = 0 ; 
        int ones = 0 ; 
        long nextZero = 0L; 
        long nextOne = 0L ; 
        for( char c : s.toCharArray() ){
            if( c == '0' ){
                zeros++ ; 
                nextOne += ones ; 
                rs += nextZero ; 
            }else {
                ones++ ; 
                nextZero += zeros ; 
                rs += nextOne ; 
            }
        }
        return rs ; 
    }
}