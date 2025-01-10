class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> rs = new ArrayList<>() ;   
        int[] pattern = new int[26] ;
        for( String in : words2 ){
            int[] tem = new int[26] ; 
            for( char c : in.toCharArray() ){
                int i = c-'a' ; 
                pattern[i] = Math.max( pattern[i] , ++tem[i] ) ; 
            }
        }
        
        for( String in : words1 ){
            int[] tem = new int[26] ;
            for( char c : in.toCharArray() ){
                tem[c-'a']++ ; 
            } 
            if( isSub( tem , pattern ) ){
                rs.add(in) ; 
            }   
        }
        return rs ;
    }
    public boolean isSub( int[] a , int[] b ){
        for( int i=0 ; i<26 ; ++i ){
            if( b[i] > a[i] ) return false ; 
        }
        return true ;
    }
}