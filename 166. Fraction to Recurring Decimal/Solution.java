import java.util.* ; 

class Solution {
    int getSign( long n ){
        return n > 0 ? 1 : -1 ; 
    }
    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal( 1L*numerator , 1L*denominator ) ; 
    }
    public String fractionToDecimal(long numerator, long denominator) {
        if( numerator == 0 ) return "0" ; 
        StringBuilder ans = new StringBuilder() ; 
        if( getSign(numerator) * getSign( denominator ) == -1 ){
            ans.append( "-" ) ; 
        }
        numerator *= getSign( numerator ) ; 
        denominator *= getSign( denominator ) ; 
        ans.append( numerator/denominator ) ; 
        numerator %= denominator ; 
        if( numerator > 0 ){
            ans.append( "." ) ;
            StringBuilder flo = new StringBuilder() ; 
            HashMap<Long,Integer> seen = new HashMap<>() ;
            int pos = 0 ;  
            while( numerator > 0 ){
                numerator *= 10 ; 
                if( seen.get( numerator ) != null ) break ;
                seen.put( numerator , pos ) ; 
                if( numerator < denominator ){
                    flo.append( 0 ) ; 
                }else {
                    flo.append( numerator / denominator ) ;
                    numerator %= denominator ; 
                }
                pos++ ; 
            } 
            if( numerator == 0 ){
                ans.append( flo ) ; 
            }else {
                int start = seen.get( numerator ) ; 
                for( int i=0 ; i<start ; ++i ){
                    ans.append( flo.charAt(i) ) ; 
                }
                ans.append( "(" ) ; 
                for( int i=start ; i<flo.length() ; ++i ){
                    ans.append( flo.charAt(i) ) ; 
                }
                ans.append( ")" ) ; 
            }
        }
        return ans.toString() ; 
    }
}