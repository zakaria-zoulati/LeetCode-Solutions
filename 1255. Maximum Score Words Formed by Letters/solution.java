class Solution {
    int rs = 0 ; 
    int[] score ; 
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score ;  
        int[] f = new int[26] ; 
        for( char c : letters ){
            f[ c- 'a']++ ; 
        }
        backtrack( f , new int[26] , words , 0  , 0 )  ;
        return rs ; 
    }

    public void backtrack( int[] f , int[] curr , String[] words , int in  , int cu  ){
        if( in == words.length ) return ; 
        backtrack( f , curr , words , in+1  , cu  ) ; 
        boolean flag = true ;
        for( char c : words[in].toCharArray() ){
            curr[ c-'a' ]++ ; 
            cu += score[ c-'a' ] ; 
            if( curr[ c-'a'] > f[c-'a'] ){
                flag = false ; 
            }
        }
        if( flag ){
            rs = Math.max( rs , cu ) ; 
            backtrack( f , curr , words , in+1 , cu ) ; 
        }
        for( char c : words[in].toCharArray() ){
            curr[ c-'a' ]-- ; 
        } 
    }

}