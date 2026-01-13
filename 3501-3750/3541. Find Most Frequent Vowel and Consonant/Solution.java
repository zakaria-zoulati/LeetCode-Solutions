class Solution {
    public int maxFreqSum(String s) {
        int[] f = new int[26] ; 
        int a = 0 , b = 0 ; 
        boolean[] isVowel = new boolean[26] ; 
        String vowels = "aeuio" ;
        for( char c : vowels.toCharArray() ){
            isVowel[ c - 'a' ] = true ; 
        }
        for( char c : s.toCharArray() ){
            int in = c-'a' ; 
            f[ in ]++ ;
            if( isVowel[ in ] ){
                a = Math.max( f[in] , a ) ; 
            }else {
                b = Math.max( f[in] , b ) ; 
            }
        }
        return a + b ; 
    }
}
