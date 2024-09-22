class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int rs = 0 ; 
        for( String item : patterns ){
            if( word.contains(item) ) rs++ ; 
        }
        return rs ; 
    }
}