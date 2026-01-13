class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray() ; 
        int n = s.length() ; 
        long mod = 1_000_000_007 ; 
        long b = 1 ; 
        long a = 0 ; 
        if( chars[n-1] != '0' ){
            a = chars[n-1]=='*'?9:1 ; 
        }
        for( int i=n-2 ; i>=0 ; --i ){
            long temp_a = 0 ; 
            char c = chars[i] ;
            if( c == '0' ){
                b = a; 
                a = 0 ; 
                continue ; 
            }
            if( c == '*' ){
                temp_a  = ( 9*a ) % mod  ; 
                temp_a = ( temp_a + ( chars[i+1] == '*' ? 9*b : b) ) % mod ; 
                if( chars[i+1] == '*' ){
                    temp_a = ( temp_a + 6*b ) % mod ; 
                }else if( chars[i+1] < '7' ){
                    temp_a = ( temp_a + b ) % mod ; 
                 }
            }else if( c > '2' ){
                temp_a = a ; 
            }else if( c == '1' ){
                temp_a = a ; 
                temp_a = ( temp_a + ( chars[i+1] == '*' ? 9*b : b ) ) % mod ;
            }else {
                temp_a = a ; 
                if( chars[i+1] == '*' ){
                    temp_a = ( temp_a + 6*b ) % mod ; 
                }else if( chars[i+1] < '7' ){
                    temp_a = ( temp_a + b ) % mod ;
                }
            }
            b = a ; 
            a = temp_a ; 
        }
        return (int) a ; 
    }
}