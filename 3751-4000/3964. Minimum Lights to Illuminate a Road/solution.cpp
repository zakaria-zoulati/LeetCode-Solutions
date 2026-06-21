class Solution {
public:
    int minLights(vector<int>& lights) {
        int n = lights.size() ; 
        vector<int> diff(n+1) ; 
        for( int i=0 ; i<n ; ++i ){
            if( lights[i] > 0 ){
                int s = max( 0 , i - lights[i] ) ; 
                int e = min( n-1 , i+lights[i] ) ; 
                diff[s]++ ; 
                diff[e+1]-- ; 
            }
        }
        for( int i=1 ; i<n ; ++i ){
            diff[i] += diff[i-1] ; 
        }

        int ans = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( diff[i] == 0 ){
                ans++ ; 
                i += 2 ; 
            }
        }
        return ans ; 
    }
};