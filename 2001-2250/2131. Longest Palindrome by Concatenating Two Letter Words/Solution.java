class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length ; 
        int[] f = new int[ 2526 ] ; 
        for( String s : words ){
            int curr = ( s.charAt(1) - 'a' ) + (  s.charAt(0) - 'a' )*100 ; 
            f[ curr ]++ ; 
        } 
        boolean fl = false ; 
        int rs = 0 ; 
        for( int i=0 ; i<2526 ; ++i ){
            if( f[i] == 0 ) continue ; 
            int r = i%100 ; 
            int op = r*100 + ( i - r )/100 ; 
            if( op == i ){
                rs += ( f[i] / 2 )*2 ; 
                if( f[i] % 2 == 1 ) fl = true ; 
            }else {
                int m = Math.min( f[i] , f[op] ) ; 
                f[op] = 0 ;
                rs += m*2 ;  
            }
        }
        if( fl ) rs++  ; 
        return rs << 1 ; 
    }
}