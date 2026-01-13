class Solution {
    public int prefixCount(String[] words, String pref) {
        int rs = 0 ; 
        int n = words.length ; 
        int len = pref.length() ;
        for(int i=0 ; i<n ; ++i ){
            if( words[i].length() < len ) continue ;
            if( words[i].startsWith(pref) ){
                rs++  ; 
            }
        }
        return rs ; 
    }
}