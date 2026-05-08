class Solution {
public:
    vector<int> maxValue(vector<int>& nums) {
        int n = nums.size() ; 

        vector<int> maxPref(n) ; 
        vector<int> minSuff(n) ; 
        vector<int> ans(n) ; 

        maxPref[0] = nums[0];
        for( int i=1;i<n ; ++i ){
            maxPref[i] = max( maxPref[i-1] , nums[i] ) ; 
        }

        minSuff[n-1] = nums[n-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            minSuff[i] = min( minSuff[i+1] , nums[i] ) ; 
        } 

        ans[n-1] = maxPref[n-1] ; 
        for( int i=n-2; i>=0 ; --i ){
            if( maxPref[i] > minSuff[i+1] ){
                ans[i] = ans[i+1] ;
            }else {
                ans[i] = maxPref[i] ; 
            }
        }

        return ans;
    }
};