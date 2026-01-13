class Solution {
    public long countSubstrings(String s, char c) {
        long rs = 0L ; 
        int n = s.length() ;
        int count = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( s.charAt(i) == c ){
                count++ ; 
                rs += count ; 
            }
        }
        return rs ; 
    }
}