class Solution {
    public:
        int longestSubarray(vector<int>& nums) {
            int n = nums.size();  
            int len = 2 ; 
            int curr = 2 ; 
            for( int i=2 ; i<n ; ++i ){
                 if( nums[i-1] + nums[i-2] == nums[i] ){
                     curr++ ; 
                 }else {
                     curr = 2 ;
                 }
                len = max( len , curr ) ; 
            }
            return len ; 
        }
    };