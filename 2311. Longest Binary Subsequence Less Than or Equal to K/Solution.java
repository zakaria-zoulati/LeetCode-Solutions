class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0 ; 
        int n = s.length() ; 
        for( char c : s.toCharArray() ){
            if( c == '0' ){
                ans++ ; 
            }
        }
        int curr = 0 ; 
        int count = 0 ;
        for( int i=n-1 ; i>=0 ; --i ){
            if( s.charAt(i) == '0' ){
                count++ ; 
            }else{
                if( curr + ( 1 << count ) <= k ){
                    ans++  ; 
                    curr += ( 1 << count ) ; 
                    count++ ; 
                }else {
                    break ; 
                }
            }
            if( count > 30 ) break ; 
        }
        return ans ; 
    }
}