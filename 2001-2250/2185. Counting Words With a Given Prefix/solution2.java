class Solution {
    public int prefixCount(String[] words, String pref) {
        int rs = 0 ;
        for( String in : words ){
            if( in.startsWith(pref) ) ++rs ; 
        }
        return rs  ; 
    }
}