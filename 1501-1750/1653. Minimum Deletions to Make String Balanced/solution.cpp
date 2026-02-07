class Solution {
public:
    int minimumDeletions(string s) {
        int n = s.size() ; 
        int dp = 0 ; 
        int bs = ( s[0] == 'b' ? 1 : 0 ) ; 
        for( int i=1 ; i<n ; ++i ){
            if( s[i] == 'b' ){
                bs++ ; 
            }else {
                dp = min( dp + 1 , bs ) ; 
            }
        }   
        return dp ; 
    }
};