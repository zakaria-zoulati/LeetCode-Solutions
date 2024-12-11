class Solution {
    int rs = 0 ; 
    int[] sc ; 
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.sc = new int[ 'z' + 1 ] ; 
        for( int i=0; i<26 ; ++i ){
            sc[ 'a' + i ] = score[i] ; 
        }
        int[] f = new int['z' + 1] ; 
        for( char c : letters ){
            ++f[c] ; 
        }
        backtrack( f , new int['z' + 1] , words , 0  , 0 )  ;
        return rs ; 
    }
    public void backtrack( int[] f , int[] curr , String[] words , int in  , int cu  ){
        if( in == words.length ) return ; 
        backtrack( f , curr , words , in+1  , cu  ) ; 
        for( int i=0 ; i<words[in].length() ; ++i ){
            char c = words[in].charAt(i) ; 
            curr[c]++ ; 
            cu += sc[c] ; 
            if( curr[c] > f[c] ){
                for( int j=i ; j>=0 ;--j ){
                    curr[ words[in].charAt(j) ]-- ; 
                }
                return ; 
            }
        }
        rs = Math.max( rs , cu ) ; 
        backtrack( f , curr , words , in+1 , cu ) ; 
        for( char c : words[in].toCharArray() ){
            curr[c]-- ; 
        } 
    }

}