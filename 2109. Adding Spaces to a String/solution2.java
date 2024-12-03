class Solution {
    public String addSpaces(String s, int[] spaces) { 
        StringBuilder rs = new StringBuilder() ; 
        int n = s.length() ; 
        int p = 0 ; 
        for( int i : spaces ){
            rs.append( s.substring(p,i) ) ;
            rs.append(" ") ; 
            p = i ; 
        }
        rs.append( s.substring(p,n) ) ; 
        return rs.toString() ; 
    }
}