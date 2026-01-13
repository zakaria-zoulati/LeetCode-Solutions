class Solution {
    public:
        int maximumEnergy(vector<int>& energy, int k) {
            int n = energy.size() ; 
            int ans = INT_MIN ; 
            for( int i=n-1 ; i>=n-k ; --i ){
                ans = max( ans , energy[i] ) ;  
            }
            for( int i=n-k-1 ; i>=0 ; --i ){
                energy[i] += energy[i+k] ; 
                ans = max( ans , energy[i] ) ; 
            }
            return ans ; 
        }
    };