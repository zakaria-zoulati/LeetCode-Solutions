class Solution {
    public int  comp( String in ){
        int n = in.length() ; 
        int rs = 0 ; 
        for(int i= n-1 ; i>=0 ; i--){
            if( in.charAt(i) == '0' ){
                rs += (1 << n-1-i ) ; 
            }
        }
        return rs ;
    }
    public int findComplement(int num) {
        StringBuilder rs = new StringBuilder() ; 
        while( num != 0  ){
            rs.append( num % 2 ) ;
            num = num >> 1    ;
        }
        return comp( rs.reverse().toString() ) ; 
    }
}