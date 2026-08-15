class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int x = 0 ; 
        int zeros = 0 ; 
        for( int num : nums ){
            if( num == 0 ) zeros++ ; 
            else x ^= num ; 
        }
        if( x != 0 ){
            return nums.size() ; 
        }
        if( zeros == nums.size() ){
            return 0 ; 
        }
        return nums.size() - 1;  
    }
};