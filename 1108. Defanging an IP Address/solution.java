class Solution {
    public String defangIPaddr(String address) {
        StringBuilder rs = new StringBuilder() ; 
        for( char c : address.toCharArray() ){
            if( c == '.' ){
                rs.append( "[.]" ) ; 
            }else{
                rs.append( c ) ; 
            }
        }
        return rs.toString() ; 
    }
}