class Solution {
    public int numberOfBeams(String[] bank) {
        int first  = 0 ; 
        int second = 0 ;
        int rs = 0 ; 
        for( String row : bank ){
            int curr = 0 ; 
            for( char c : row.toCharArray() ){
                curr += c - '0' ; 
            }
            if( curr > 0 ){
                first = second ; 
                second = curr ; 
                rs += first*second ; 
            }
        } 
        return rs ; 
    }
}