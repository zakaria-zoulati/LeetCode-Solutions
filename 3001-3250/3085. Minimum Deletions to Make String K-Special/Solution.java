class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length() ; 
        int[] f = new int[26] ; 
        for( char c : word.toCharArray() ){
            f[c-'a']++ ; 
        }
        int rs = Integer.MAX_VALUE ; 
        for( int i=0 ; i<26 ; ++i ){
            if( f[i] == 0 ) continue ; 
            int curr = 0;
            for( int j=0 ; j<26 ; ++j ){
                if( f[j] == 0 || i == j ) continue ; 
                if( f[j] < f[i] ){
                    curr += f[j] ; 
                }else if( Math.abs( f[i] - f[j] ) > k ){
                    curr += Math.abs( f[i] - f[j] ) - k ; 
                }
            }
            rs = Math.min( rs , curr ) ; 
        }
        return rs ; 
    }
}