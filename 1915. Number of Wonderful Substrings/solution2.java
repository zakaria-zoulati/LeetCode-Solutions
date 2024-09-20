class Solution {
    public long wonderfulSubstrings(String word) {
        long rs = 0  ; 
        int xor = 0 ; 
        int[] map = new int[1024] ; 
        map[0] = 1 ; 
        for( char c : word.toCharArray() ){
            xor ^=  1 << ( c - 'a' ) ; 
            for( int i=0 ; i<10 ; ++i ){
                rs += map[ ( 1 << i ) ^ xor ] ; 
            }
            rs += map[ xor ]++ ; 
        }
        return rs ;
    }
}