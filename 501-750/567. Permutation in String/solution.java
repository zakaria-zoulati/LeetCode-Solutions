class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length() ; 
        int m = s2.length() ; 
        if( n > m ){
            return false ; 
        }
        int[] f1 = new int[26] ; 
        int[] f2 = new int[26] ; 
        for( char c : s1.toCharArray() ){
            f1[ c - 'a' ]++ ; 
        }
        for(int i=0 ; i<n ; ++i ){
            f2[ s2.charAt(i) - 'a' ]++ ;
        }
        int count = 0 ; 
        for(int i=0 ; i<26 ; ++i ){
            if( f1[i] == f2[i]) count++ ; 
        }
        if( count == 26  ) return true ; 
        all:for(int i=n ; i<m ; ++i){
           f2[ s2.charAt( i-n ) - 'a' ]-- ; 
           f2[ s2.charAt(i) - 'a' ]++ ; 
           for(int j=0 ; j<26 ; ++j){
                if( f1[j] != f2[j] ) continue all ; 
           }
           return true ; 
        }

        return false ; 
}
}