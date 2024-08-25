class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26] ; 
        for( char c : s.toCharArray() ){
            freq[ c - 'a' ]++ ;
        }
        Arrays.sort( freq ) ; 
        int rs = 0; 
        for(int i = 25 ; i>=1 ;--i ){
            if( freq[i] == 0  ) continue ;
            int j = i ; 
            while( j-1>=0 && freq[i] == freq[j-1] ){
                freq[j-1]-- ; 
                j-- ; 
                rs++ ; 
            }
        }
        return rs; 
    }
}