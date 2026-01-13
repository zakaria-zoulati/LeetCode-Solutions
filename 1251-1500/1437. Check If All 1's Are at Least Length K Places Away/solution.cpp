class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        if( k == 0 ) return true ; 
        int prev = -2*k ; 
        int n = nums.size() ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] == 1 ){
                if( i - prev - 1 < k ){ 
                    return false ; 
                }
                prev=i ; 
            }
        }
        return true ; 
    }
};