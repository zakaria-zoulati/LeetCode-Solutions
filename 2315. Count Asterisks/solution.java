class Solution {
    public int countAsterisks(String s) {
        boolean flag = false ; 
        int rs = 0 ; 
        for( char c : s.toCharArray() ){
            if( c == '|' ){
                flag = !flag ; 
            }
            else if( !flag && c == '*'  ) rs++ ;
        }
        return rs ; 
    }
}