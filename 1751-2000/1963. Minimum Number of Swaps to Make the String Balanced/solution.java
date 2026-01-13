class Solution {
    public int minSwaps(String s) {
        int rs = 0 ; 
        int left = 0 ; 
        int right = 0 ; 
        for( char c : s.toCharArray() ){
            if( c == ']' ){
                if( left <= right ){
                    left++ ; 
                    rs++ ; 
                }else {
                    right++ ; 
                }
            }else {
                left++ ; 
            }
        }
        return rs ; 
    }
}