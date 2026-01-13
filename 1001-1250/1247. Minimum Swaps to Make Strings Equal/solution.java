class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length() ; 
        int x = 0 ; 
        int y = 0 ;
        for( int i=0;i<n ; ++i ){
            if( s1.charAt(i) != s2.charAt(i) ){
                if( s1.charAt(i) == 'x'  ){
                        ++x ; 
                }else {
                        ++y ; 
                }
            }
        }
        if( (x+y) % 2 == 0 ){
            int rs = 0 ; 
            if( x%2 == 0 ){
                rs = x/2  + y/2 ; 
            }else {
                rs = x/2 + y/2 + 2 ; 
            }
            return rs ; 
        }
        return -1 ; 
    }
}