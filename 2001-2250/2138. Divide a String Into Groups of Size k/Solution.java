class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length() ; 
        if( n % k != 0 ){
            s = s + String.valueOf(fill).repeat( k - n%k ) ; 
        }
        int len = s.length()/k ; 
        String[] rs = new String[ len ] ; 
        for( int i=0 ; i<len ; ++i ){
            rs[i] = s.substring(i*k,(i+1)*k) ;
        }
        return rs ; 
    }
}