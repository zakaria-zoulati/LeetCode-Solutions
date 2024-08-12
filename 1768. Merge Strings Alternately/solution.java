class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder rs = new StringBuilder() ; 
        int n = word1.length() ; 
        int m = word2.length() ; 
        int marker1 = 0; 
        int marker2 = 0 ;

        while(  marker1<n || marker2 < m  ){
            if( marker1 < n ){
                rs.append(  word1.charAt(marker1) )  ;
                marker1++ ; 
            }
            if( marker2 < m){
                rs.append( word2.charAt(marker2) ) ; 
                marker2++  ;
            }
        }
        return rs.toString();

    }
}