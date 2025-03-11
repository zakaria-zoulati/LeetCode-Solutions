class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length() ; 
        char[] chars = s.toCharArray() ; 
        int[] f = new int[100] ; 
        int rs = 0 ;
        int left = 0 ; 
        int cdt = 0 ; 
        for( int i = 0 ; i<n ; ++i ){ 
            f[ chars[i] ]++ ; 
            cdt |= ( 1 << ( chars[i] - 'a' ) ) ; 
            if( cdt == 7 ){
                while( f[ chars[left] ] > 1 ){
                    f[ chars[left++] ]-- ; 
                }
                rs += left+1 ; 
            }
        }
        return rs ; 
    }
}