class Solution {
    public String majorityFrequencyGroup(String s) {
        int n = s.length()  ;
        int[] f = new int[26] ; 
        for( char c : s.toCharArray() ){
            ++f[c-'a'] ; 
        }
        int[] ff = new int[n+1] ;
        int m = 1 ; 
        for( char c = 'a' ; c<='z' ; c += 1 ){
            ff[ f[c-'a'] ]++ ; 
        }
        for( int i=1 ; i<=n ; ++i ){
            if( ff[i] >= ff[m] ) m = i ; 
        }
         String rs = "" ; 
        for( char c = 'a' ; c<='z' ; c += 1 ){
            if( f[c-'a'] == m ){
                rs += c ; 
            }
        }
        return rs ; 
    }
}