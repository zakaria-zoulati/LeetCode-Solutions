class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder rs = new StringBuilder() ; 
        int n = s.length() ; 
        int counter = 0 ; 
        for(int i=n-1 ; i>=0 ; i--){
            if( s.charAt(i) != '-' ){
                if( counter == k ){
                    rs.append( '-' ) ; 
                    rs.append( s.charAt(i) ) ; 
                    counter = 1; 
                }
                else {
                    rs.append( s.charAt(i) ) ; 
                    counter++ ; 
                }
                
            }
        }
        return rs.reverse().toString().toUpperCase() ;
    }
}