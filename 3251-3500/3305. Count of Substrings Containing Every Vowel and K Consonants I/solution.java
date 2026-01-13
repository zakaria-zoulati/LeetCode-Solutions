class Solution {
    String temp = "aeuio" ; 
    public int countOfSubstrings(String word, int k) {
        int n = word.length() ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+4+k ; j<n ; ++j ){
                int[] f = new int[26] ; 
                for( int t=i ; t<=j ; ++t ){
                    f[ word.charAt(t) - 'a' ]++; 
                }
                if( isValid( f , k ) ){
                    ++rs ; 
                    while( j+1<n && temp.indexOf( word.charAt(j+1) ) != -1 ){
                        ++rs ; 
                        ++j ; 
                    }
                    break ; 
                }
            }
        }
        return rs ; 
    }
    public boolean isValid( int[] f , int k ){
        int co = 0 ; 
        for( char c='a' ; c<='z' ; ++c ){
            if( temp.indexOf(c) != -1 ){
                if( f[c-'a'] == 0 ) return false  ; 
            }else {
                co += f[  c-'a' ] ; 
            }
        }
        return co == k ; 
    }
}