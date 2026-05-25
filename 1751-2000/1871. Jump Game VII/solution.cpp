class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.size() ; 
        if( s[n-1] == '1' ) return false ; 
        if( n <= 2 ) return true ; 
        vector<int> diff( n+1 , 0 ) ; 
        for( int i=0 ; i<n ; ++i ){
            if( i == 0 ){
                if( minJump < n ){
                    diff[minJump]++ ; 
                }else {
                    return false ; 
                }
                if( maxJump + 1 < n ){
                    diff[maxJump+1]-- ; 
                }
            }else {
                diff[i] += diff[i-1] ; 
                if( s[i] == '0' && diff[i] > 0 ){
                    if( i + minJump < n ){
                        diff[i+minJump]++ ; 
                    }
                    if( i+maxJump+1<n ){
                        diff[i+maxJump+1]-- ; 
                    }
                }
            }
        }
        return diff[n-1] > 0 ; 
    }
};