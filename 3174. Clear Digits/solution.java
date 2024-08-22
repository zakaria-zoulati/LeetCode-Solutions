class Solution {
    public String clearDigits(String s) {
        StringBuilder rs = new StringBuilder() ; 
        int n = s.length() ; 
        int inter = 0 ; 
        for(int i=n-1 ; i>=0 ; --i){
            if( s.charAt(i) >='0' && s.charAt(i) <= '9' ){
                inter++ ; 
            }else {
                if( inter > 0 ) inter-- ; 
                else {
                    rs.append( s.charAt(i) ) ;
                }
            }
        }
        return rs.reverse().toString() ; 
    }
}