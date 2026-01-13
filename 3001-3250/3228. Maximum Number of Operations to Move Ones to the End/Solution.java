class Solution {
    public int maxOperations(String s) {
        int n = s.length() ; 
        int prev = 0 ; 
        int ans = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) =='1' ) prev++ ; 
            else{
                ans += prev ; 
                while( i+1<n && s.charAt(i+1) == '0' ) i++ ; 
            } 
        }
        return ans ; 
    }
}