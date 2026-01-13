class Solution {
    public int maxDepth(String s) {
        int rs = 0 ; 
        int a = 0 ; 
        for( char ch : s.toCharArray() ){
            if( ch == '(' ){
                a++ ; 
                rs = Math.max( a , rs ) ; 
                continue ; 
            }
            if( ch == ')' ){
                a-- ; 
            }
        }
        return rs  ;
    }
}