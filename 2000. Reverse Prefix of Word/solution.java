class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder rs = new StringBuilder() ;
        boolean flag = true ; 
        for(char c : word.toCharArray() ){
            rs.append( c ) ; 
            if( c == ch && flag  ){
                rs = rs.reverse() ;
                flag = false ; 
            }
        }
        return rs.toString() ;
    }
}