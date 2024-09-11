class Solution {
    public int numberOfSpecialChars(String word) {
        int[] min = new int[26] ; 
        int[] maj = new int[26] ;
        for( char c : word.toCharArray() ){
            if( c>='a' && c<='z'){
                min[ c - 'a']++ ; 
            }else {
                maj[ c - 'A' ]++ ; 
            }
        } 
        int rs = 0 ; 
        for(int i=0 ; i<26 ; ++i){
            if( min[i]>0 && maj[i]>0 ) rs++ ; 
        }
        return rs ; 
    }
}