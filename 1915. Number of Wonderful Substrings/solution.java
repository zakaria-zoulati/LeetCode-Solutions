class Solution {
    public long wonderfulSubstrings(String word) {
        long rs = 0  ; 
        int xor = 0 ; 
        int odd = 0; 
        int count = 0 ; 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        map.put(0,1) ; 
        for( char c : word.toCharArray() ){
            xor ^=  1 << ( c - 'a' ) ; 
            for( int i=0 ; i<32 ; ++i ){
                rs += map.getOrDefault(  ( 1 << i ) ^ xor  , 0  ) ; 
            }
            rs += map.getOrDefault( xor  , 0 ) ; 
            map.put( xor , map.getOrDefault(xor,0) + 1 ) ; 
        }
        return rs ;
    }
}