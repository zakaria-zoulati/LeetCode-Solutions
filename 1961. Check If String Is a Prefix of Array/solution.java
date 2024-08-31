class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder rs = new StringBuilder() ; 
        for( String c : words ){
            rs.append( c )  ;
            if( rs.length() > s.length() ) return false; 
            if( s.equals(rs.toString() ) ) return true ;
        }
        return false  ;
    }
}