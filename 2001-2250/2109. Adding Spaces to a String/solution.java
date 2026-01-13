class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        int c = 0 ; 
        int ss = spaces.length ; 
        for( int i=0 ; i<n ; ++i ){ 
           if( c<ss && i == spaces[c] ){
                rs.append(" ") ;
                ++c ; 
           }
           rs.append( s.charAt(i) ) ; 
        }
        return rs.toString() ; 
    }
}