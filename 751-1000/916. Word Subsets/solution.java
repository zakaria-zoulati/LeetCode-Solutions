class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> rs = new ArrayList<>() ; 
        int n = words1.length ; 
        int m = words2.length ; 
        int[][] f1 = new int[n][26] ; 
        int[][] f2 = new int[m][26] ;
        // Fill The frequecy array f1
        for( int i=0 ; i<n ; ++i ){
            for( char c : words1[i].toCharArray() ){
                f1[i][ c-'a' ]++ ; 
            } 
        } 
        // Fill The frequecy array f2
        for( int i=0 ; i<m ; ++i ){
            for( char c : words2[i].toCharArray() ){
                f2[i][ c-'a' ]++ ; 
            } 
        } 
        int[] pattern = new int[26] ;
        for( int i=0 ; i<m ; ++i ){
            for( int j=0 ; j<26 ; ++j ){
                pattern[j] = Math.max( pattern[j] , f2[i][j] ) ; 
            }
        }
        m:for( int i=0 ; i<n; ++i ){
            for( int j=0 ; j<26 ; ++j ){
                if( pattern[j] > f1[i][j] ){
                    continue m ; 
                }
            }
            rs.add( words1[i] ) ;
        }

        return rs  ;
    }
}