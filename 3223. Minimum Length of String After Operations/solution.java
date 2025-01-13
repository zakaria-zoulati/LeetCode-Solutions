class Solution {
    public int minimumLength(String s) {
        int[] f = new int[128] ; 
        for( char c : s.toCharArray() ){
            ++f[c] ; 
        }
        int rs = 0 ; 
        for( int i : f ){
            if( i >= 3 ){
                rs += 1 + (i%2==0?1:0) ;
            }else {
                rs += i ; 
            }
        }
        return rs  ;
    }
}