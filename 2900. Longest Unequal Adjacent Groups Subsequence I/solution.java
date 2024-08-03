class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>() ; 
        int n = words.length ; 
        list.add( words[0] ) ; 
        int curr = groups[0] ; 
        for( int i=1  ;i<n ; i++ ){
            if( (groups[i]^current) == 1   ){
                list.add( words[i] ) ; 
                current = groups[i] ;
            }
        }
        return list ; 
    }
}