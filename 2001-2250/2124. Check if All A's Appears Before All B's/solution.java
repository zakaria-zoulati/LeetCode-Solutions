class Solution {
    public boolean checkString(String s) {
        boolean flag = false ; 
        for( char c : s.toCharArray()){
            if( flag ){
                if( c=='a' ) return false ;
            }else {
                if( c == 'b' ){
                    flag = true; 
                }
            }
        }
        return true  ;
    }
}