class Solution {
    public int numberOfSpecialChars(String word) {
        int rs = 0 ;
        int n = word.length() ; 
        int[] flag = new int[26] ; 
        for(int i=0 ; i<n ; ++i){
            char c = word.charAt(i) ; 
            if( c >= 'a' && c <= 'z' ){
                if( flag[ c- 'a' ] == 0 || flag[ c- 'a' ] == 1  ){
                    flag[ c - 'a' ] = 1 ; 
                }else {
                    flag[ c - 'a' ] = -1 ; 
                }
            }else {
                c = ( char ) (c + 32) ; 
                if( flag[ c - 'a' ] == 1 ){
                    flag[ c - 'a' ] = 2 ; 
                }else if( flag[ c - 'a'] == 0 ){
                    flag[ c - 'a' ] = -1 ; 
                }
            }
        }
        for( int num : flag){
            if( num == 2 ) rs++ ;
        }
        return rs  ;
    }
}