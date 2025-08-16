class Solution {
    public:
        long long perfectPairs(vector<int>& nums) {
            int n = nums.size();
            int start = 0;
            long long rs = 0;
            for( int i=0 ; i<n ; ++i ){
                nums[i] = abs( nums[i] ) ; 
            }
            sort(nums.begin(), nums.end());
            for(int i = 1; i < n; ++i) {
                while(start < i && 2L*nums[start] < nums[i] ) {
                    start++;
                }
                rs += i - start;
            }
            return rs;
        }
    };