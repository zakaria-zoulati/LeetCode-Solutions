class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128] ; 
        int n = s.length() ; 
        int odds = 0 ; 
        int evens = 0 ;
        for(int i=0 ;i<n ; ++i){
            freq[ s.charAt(i) - 'A' ]++ ; 
        }
        for(int i=0 ; i<128 ; ++i){
            if( (freq[i] & 1) == 0  ){
                evens += freq[i] ; 
            }
            else{
                evens += freq[i] -1 ;
                odds = 1; 
            }
        }
        return odds+evens ; 
    }
}