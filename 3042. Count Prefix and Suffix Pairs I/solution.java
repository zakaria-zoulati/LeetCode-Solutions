class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                if( words[j].indexOf( words[i]) == 0 && words[j].lastIndexOf( words[i]) == words[j].length() - words[i].length()){
                    ++rs ; 
                }
            }
        }
        return rs ; 
    }
}