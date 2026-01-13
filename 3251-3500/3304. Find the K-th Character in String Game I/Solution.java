class Solution {
    public int helper( int n ){
        if( n == 1 ){
            return 0 ; 
        }
        if( (n&(n-1)) == 0 ){
            return ( helper( n/2 ) + 1 ) % 26 ; 
        }else {
            int m = n ; 
            while( (m&(m-1)) != 0 ){
                m -= m&(-m) ; 
            }
            return ( helper(n%m) + 1 ) % 26 ; 
        }
    }
    public char kthCharacter(int k) {
       int pos = helper(k) ; 
       char c = (char) ('a' + pos) ; 
       return c ; 
    }
}