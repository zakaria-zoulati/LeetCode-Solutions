class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int rs = 0 ; 
        for( int i=0 ; i<words.length ; ++i ){
            for( int j=i+1 ; j<words.length ; ++j ){
                int a = words[i].length() ; 
                int b = words[j].length() ; 
                if( a == b && ( a == 0 || ( words[i].charAt( a-1 ) == words[j].charAt(0) && words[i].charAt( 0 ) == words[j].charAt( b-1 )  )  ) ){
                    rs++  ; 
                }
            }
        }
        return rs ; 
    }
}