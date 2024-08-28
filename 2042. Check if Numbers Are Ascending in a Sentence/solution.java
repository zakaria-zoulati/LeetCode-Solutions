class Solution {
    public boolean areNumbersAscending(String s) {
        int curr = 0 ; 
        int n = s.length() ; 
        int inter = 0 ; 
        for(int i=0; i<n ; ++i ){
            if( s.charAt(i) >= '0' &&  s.charAt(i) <= '9' ){
                inter += s.charAt(i) - '0' ; 
                while( i+1 < n &&   s.charAt(i+1) >= '0' &&  s.charAt(i+1) <= '9'){
                    inter *= 10 ; 
                    inter += s.charAt(i+1) - '0' ; 
                    i++ ;
                }
                if( curr >= inter ) return false ;
                curr = inter ; 
                inter = 0 ; 
            }
        }
        return true ; 

    }
}