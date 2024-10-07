class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length() ; 
        int count = 0 ; 
        for( char c : s.toCharArray() ){
            if( c == letter ) count++ ; 
        }
        return ( count * 100 )/ n ; 
    }
}