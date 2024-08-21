class Solution {
    public int findPermutationDifference(String s, String t) {
        int n = s.length() ; 
        int rs = 0 ; 
        int[] a = new int[26] ; 
        int[] b = new int[26] ; 
        for(int i=0 ; i<n ; ++i){
            a[ s.charAt(i) - 'a' ]  = i ;
            b[ t.charAt(i) - 'a' ] = i  ;
        }
        for(int i=0 ; i<26 ; ++i ){
            rs += Math.abs( a[i] - b[i] )  ;
        }
        return rs ; 
    }
}