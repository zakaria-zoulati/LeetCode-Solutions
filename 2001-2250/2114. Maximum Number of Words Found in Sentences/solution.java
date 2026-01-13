class Solution {
    public int mostWordsFound(String[] sentences) {
        int rs = 0 ; 
        for( String item : sentences ){
            rs = Math.max( rs , item.split(" ").length ) ; 
        }
        return rs ; 
    }
}