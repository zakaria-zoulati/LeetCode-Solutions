class Solution {
    public String generateTheString(int n) {
        StringBuilder rs = new StringBuilder() ; 
        if( n%2 == 0 ){
            for(int i=0 ; i<n-1 ; ++i){
                rs.append('a') ; 
            }
            rs.append('b') ;
        }else {
            for(int i=0 ; i<n ; ++i){
                rs.append('a') ; 
            }
        }
        return rs.toString() ; 
    }
}