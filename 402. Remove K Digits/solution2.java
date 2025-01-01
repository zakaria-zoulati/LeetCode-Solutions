class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length() ; 
        if( n == k ){
            return "0" ; 
        }
        char[] s = new char[n] ;
        int in = 0 ;
        s[0] = num.charAt(0) ; 
        int count = 0 ; 
        for( int i=1 ; i<n ; ++i ){
            while( in != -1  && count < k && s[in] > num.charAt(i) ){
                --in ; 
                ++count ; 
            }
            s[++in] = num.charAt(i) ; 
        }
        while( count < k ){
            --in ; 
            ++count ; 
        }
        int start = 0 ; 
        while( start < in+1 && s[start] == '0' ) ++start ; 
        if( start == in+1 ) return "0" ;
        return new String( s , start , in - start+1 ) ; 
    }
}