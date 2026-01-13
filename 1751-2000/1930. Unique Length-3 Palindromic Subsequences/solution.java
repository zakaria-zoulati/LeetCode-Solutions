class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        int rs = 0 ; 
        for (char c : s.toCharArray()) {
            ++right[c - 'a'];
        }
        int[] hash = new int[26] ; 
        for (char c : s.toCharArray()) {
            int in = c - 'a' ;
            --right[in];
            for (int j = 0; j < 26; ++j) {
                if ( right[j] > 0 && left[j] > 0 ) {
                    hash[j] |= ( 1 << in ) ; 
                }
            }
            ++left[in];
        }
        for( int i : hash ){
            while( i > 0 ){
                rs += ( i & 1 ) ; 
                i >>= 1 ;
            }
        }
        return rs ; 
    }
}