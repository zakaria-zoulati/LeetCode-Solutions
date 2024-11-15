class Solution {
    public int bestClosingTime(String s) {
        int i = 1 ; 
        int p = 0 ;
        int rs = 0 ; 
        int b = 0 ; 
        for( char c : s.toCharArray() ){
            if( c == 'Y'){
                --p ;  
                if( p < b ){
                    b = p ; 
                    rs = i ; 
                }
            }else {
                ++p ; 
            }
            ++i ; 
        }
        return rs ; 
    }
}