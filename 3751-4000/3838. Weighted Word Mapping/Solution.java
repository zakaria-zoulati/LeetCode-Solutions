class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length ; 
        StringBuilder ans = new StringBuilder(); 
        for( int i=0 ; i<n ; ++i ){
                int curr = 0 ; 
                for( char c : words[i].toCharArray() ){
                    curr += weights[c-'a'] ; 
                }
                curr %= 26 ; 
                curr = 25 - curr ; 
                ans.append( (char) ( 'a' + curr ) ) ; 
        }
        return ans.toString() ; 
    }
}