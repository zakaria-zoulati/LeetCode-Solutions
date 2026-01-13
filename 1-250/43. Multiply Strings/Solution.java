class Solution {
    public String multiply(String num1, String num2) {
        if( num1.equals( "0" ) || num2.equals( "0" ) ){
            return "0" ; 
        }
        int n = num1.length() ; 
        int m = num2.length() ; 
        int len = n+m+5 ; 
        int[] rs = new int[ len ] ;
        for( int i=0 ; i<n ; ++i ){
            int a = num1.charAt(i) - '0' ; 
            if( a == 0 ) continue ; 
            for( int j=0 ; j<m ; ++j ){
                int b = num2.charAt(j) - '0' ; 
                rs[n+m-i-j-2] += ( a*b ) ; 
            }
        }
        int next = 0 ; 
        for( int i=0 ; i<len ; ++i ){
            rs[i] += next ; 
            next = rs[i]/10 ;
            rs[i] %= 10 ; 
        }
        int in = len-1 ; 
        while( rs[in] == 0 ) in-- ;  
        StringBuilder sb = new StringBuilder() ; 
        for( ; in>=0 ; --in ){
            sb.append( rs[in] ) ; 
        }
        return sb.toString() ; 
    }
}