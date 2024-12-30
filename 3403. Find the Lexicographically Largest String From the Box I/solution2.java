class Solution {
    public String answerString(String word, int num) {
        int n = word.length() ; 
        if( num == 1 ){
            return word  ; 
        }
        String rs = word.substring( 0 , Math.min( n , n-num+1 ) )  ; 
        for( int i=1 ; i<n ; ++i ){ 
            String next = word.substring( i , Math.min( n , i+n-num+1 ) ) ; 
            if( next.compareTo( rs ) > 0 ){
                rs = next ; 
            }   
        } 
        return rs ; 
    }
}