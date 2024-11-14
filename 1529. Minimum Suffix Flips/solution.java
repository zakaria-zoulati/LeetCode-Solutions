class Solution {
    public int minFlips(String t) {
        int n = t.length() ;  
        int rs = 0 ; 
        int i=0 ; 
        while( i<n && t.charAt(i) == '0' ) ++i ; 
        for( ;i<n;++i){
            while( i+1<n && t.charAt(i+1) == '1' ){
                ++i ;
            }
            ++rs ; 
            if( i+1<n && t.charAt(i+1) == '0' ){
                ++rs ; 
                while( i+1<n && t.charAt(i+1) == '0' ) ++i ; 
            }
        }
        return rs ; 
    }
}