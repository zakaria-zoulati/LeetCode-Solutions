class Solution {
public:
    int minimumCost(vector<int>& nums) {
        int n = nums.size() ; 
        int a = nums[1] ; 
        int b = nums[2] ; 
        for( int i=3 ; i<n ; ++i ){
            if( nums[i] < a ){
                b = min( b , a ) ; 
                a = nums[i] ; 
            }else if( nums[i] < b ){
                b = nums[i] ; 
            }
        }
        return nums[0] + a + b ; 
    }
};