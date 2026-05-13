class Solution {
public:
    int minMoves(vector<int>& nums, int limit) {
        int n = nums.size() ;
        vector<int> diff( limit * 2 + 2 , 0 ) ;
        for( int i=0 ; i<n/2 ; ++i ){
            int x = min(nums[i],nums[n-1-i])+1;
            int y = max(nums[i],nums[n-1-i])+limit;
            int curr = nums[i] + nums[n-1-i] ; 
            diff[2] += 2 ; 
            diff[x] -= 1 ; 
            diff[curr] -= 1 ; 
            diff[curr+1]++ ;
            diff[y+1]++ ; 
        }       
        int ans = n ; 
        for( int i=2 ; i<=2*limit ; ++i ){
            diff[i] += diff[i-1] ; 
            ans = min( ans , diff[i] ) ; 
        }
        return ans ; 
    }
};