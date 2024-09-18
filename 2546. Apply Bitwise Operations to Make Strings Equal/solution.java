class Solution {
    public boolean makeStringsEqual(String s, String target) {
       boolean flag1 = false ; 
       boolean flag2 = false ; 
       for( char c : s.toCharArray() ){
            if( c == '1' ){
                flag1 = true ; 
                break ; 
            }
       }
        for( char c : target.toCharArray() ){
            if( c == '1' ){
                flag2 = true ; 
                break ; 
            }
       }

       if( ( !flag1 && !flag2 ) || (  flag1 && flag2 ) ){
            return true ; 
       }
       return false ; 
       
    }
}