class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length() ; 
        int[] f = new int[100] ; 
        int rs = 0 ;
        int left = 0 ; 
        int cdt = 0 ; 
        for( int i = 0 ; i<n ; ++i ){ 
            f[s.charAt(i)]++ ; 
            cdt |= ( 1 << ( s.charAt(i) - 'a' ) ) ; 
            if( cdt == 7 ){
                while( f[ s.charAt(left) ] > 1 ){
                    f[s.charAt(left++) ]-- ; 
                }
                rs += left+1 ; 
            }
        }
        return rs ; 
    }
}