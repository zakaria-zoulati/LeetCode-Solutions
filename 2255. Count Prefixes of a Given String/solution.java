class Solution {
    public int countPrefixes(String[] words, String s) { 
        int rs = 0 ; 
        for( String item : words ){
            if( s.startsWith(item) ) rs++ ; 
        }
        return rs  ;
    }
}