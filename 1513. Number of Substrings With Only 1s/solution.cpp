class Solution {
public:
    int numSub(string s) {
        int ans = 0 ; 
        int mod = 1e9 + 7 ; 
        int prev = 0; 
        for( char c : s ){
            if( c == '1' ){
                prev++ ; 
                ans = ( ans + prev ) % mod ; 
            }else {
                prev = 0 ; 
            }
        }
        return ans;  
    }
};