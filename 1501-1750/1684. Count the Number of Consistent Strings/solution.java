class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] cdt = new int[26] ; 
        for( char c : allowed.toCharArray() ){
            cdt[ c - 'a' ]++ ;
        }
        int n = words.length ; 
        int rs = 0 ; 
        ok:for( String s : words  ){
            for( char c : s.toCharArray() ){
                if( cdt[ c - 'a' ]  == 0 ) continue ok ;
            }
            rs++;
        }
        return rs ; 
    }
}