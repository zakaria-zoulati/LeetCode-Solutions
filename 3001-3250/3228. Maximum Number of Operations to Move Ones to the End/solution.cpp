class Solution {
public:
    int maxOperations(string s) {
        int n = s.size() ; 
        int ans = 0 ; 
        int prev = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s[i] == '1' ) prev++ ; 
            else {
                ans += prev ; 
                while( i+1<n && s[i+1] == '0' ) i++ ;
            }
        }
        return ans;
    }
};