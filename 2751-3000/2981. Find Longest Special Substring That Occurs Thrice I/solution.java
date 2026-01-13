class Solution {
    public int maximumLength(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        int[][] f = new int[26][n+1] ; 

        for( int i=0 ; i<n ; ++i ){
            char c = s.charAt(i) ; 
            int count = 1 ; 
            while( i+1<n && s.charAt(i+1) == c ){
                ++count; 
                ++i ; 
            }
            for( int j=1; j<=count ; ++j ){
                f[ c-'a'][j] += (int) count - j + 1 ; 
            }
        }

        for( int i=0 ; i<26 ; ++i ){
            for( int j = rs+1 ; j<n+1 ; ++j ){
                if( f[i][j] >= 3 ){
                    rs = j ; 
                }else {
                    break ; 
                }
            }
        }
        if( rs == 0 ){
            return  -1 ; 
        }
        return rs ; 
    }
}