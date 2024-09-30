class Solution {
    public int minOperations(String s) {
        int c1 = 0 ; 
        int c2 = 0 ; 
        boolean flag = true ; 
        for( char c : s.toCharArray() ){
            if( flag ){
                if( c == '1' ) ++c1 ; 
                else ++c2 ; 
            }else {
                if( c == '1' ) ++c2 ; 
                else ++c1 ; 
            }
            flag = !flag ; 
        }
        return Math.min( c1 , c2 ) ; 
    }
}