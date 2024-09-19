class Solution {
    public int val( String s ){
        int rs = 0  ; 
        for( char c : s.toCharArray() ){
            rs = rs*10 + ( c - 'a' ) ; 
        }
        return rs ; 
   }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return val( firstWord ) + val( secondWord ) == val( targetWord ) ; 
    }
}