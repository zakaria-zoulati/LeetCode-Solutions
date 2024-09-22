class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if( s.length() != words.size() ){
            return false ; 
        }
        int n = s.length() ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) != words.get(i).charAt(0) ) return false ;
        }
        return true ; 
    }
}