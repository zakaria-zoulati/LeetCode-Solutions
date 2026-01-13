class Solution {
    public String removeStars(String s) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder(); 
        int count = 0 ; 
        for( int i=n-1 ; i>=0 ;  ){
            if( s.charAt(i) != '*' ){
                if( count > 0 ){
                    --count ; 
                    --i ;  
                }else {
                    rs.append( s.charAt(i) ) ; 
                    --i ;
                }
            }else {
                ++count ; 
                --i; 
            }
        }
        return rs.reverse().toString() ; 
    }
}