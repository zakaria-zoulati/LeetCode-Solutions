class Solution {
    public int removeAlmostEqualCharacters(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        for(int i=0 ; i<n-1 ; ++i){
            if( s.charAt(i) == s.charAt(i+1) || Math.abs( s.charAt(i) - s.charAt(i+1) ) == 1 ){
                rs++ ; 
                i++ ;
            }
        }
        return rs ; 
    }
}