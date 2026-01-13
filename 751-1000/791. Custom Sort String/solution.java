class Solution {
    public String customSortString(String order, String s) {
        int n = order.length() ; 
        int[] freq = new int[26] ; 
        for( char c : s.toCharArray() ){
            freq[ c - 'a' ]++ ; 
        }

        StringBuilder rs = new StringBuilder() ; 
        for(int i=0 ; i<n ; ++i){
            while( freq[ order.charAt(i) - 'a' ]-- > 0 ){
                rs.append( order.charAt(i) ) ; 
            }
        }

        for( int i = 0 ; i<26 ; ++i ){
            while( freq[ i ]-- > 0 ){
                rs.append(  (char) ( 'a' + i )  ) ; 
            }
        }
        return rs.toString() ; 
    }
}