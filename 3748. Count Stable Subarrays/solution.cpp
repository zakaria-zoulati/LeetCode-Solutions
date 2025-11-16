using ll = long long  ; 

class Solution {
public:
    vector<ll> countStableSubarrays(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size() ; 
        int q = queries.size() ; 
        int curr = 0 ;
        vector<ll> pref(n) ; 
        vector<int> seq(n) ;  
        for( int i=0 ; i<n ; ++i ){
            if( i > 0 && nums[i] >= nums[i-1] ){
                curr++ ; 
            }else {
                curr = 1 ; 
            }
            seq[i] = curr ; 
            if( i > 0 ){
                pref[i] = pref[i-1] ; 
            }
            pref[i] += curr ; 
        }

        vector<int> suff(n) ; 
        suff[n-1] = 1 ;
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i] > nums[i+1] ){
                suff[i] = 1 ; 
            }else {
                suff[i] = suff[i+1] + 1 ; 
            }
        }

        vector<ll> ans(q) ; 
        for( int i=0 ; i<q; ++i ){
            ll l = queries[i][0] ; 
            ll r = queries[i][1] ; 
            if( l == r ){
                ans[i] = 1 ;
            }else if( l == 0 ){
                ans[i] = pref[r] ; 
            }else {
                ans[i] = pref[r] ; 
                if( nums[l-1] <= nums[l] ){
                    ll prev = seq[l-1] ; 
                    int start = l - prev ; 
                    if( start > 0 ){
                        ans[i] -= pref[start-1] ; 
                    }
                    ll rem = min( suff[start] - prev , r-l+1 ) ; 
                    ans[i] -= rem*prev ; 
                    ans[i] -= prev*( prev+1 )/2 ; 
                }else {
                    ans[i] -= pref[l-1] ; 
                }
            }
        }
        return ans ;
    }
};