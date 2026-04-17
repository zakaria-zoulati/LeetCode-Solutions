class Solution {
public:
    int reverse( int n ){
        int rev = 0 ; 
        while( n > 0 ){
            rev *= 10 ; 
            rev += n % 10 ; 
            n /= 10 ; 
        }
        return rev ; 
    }
    int minMirrorPairDistance(vector<int>& nums) {
        int n = nums.size();  
        unordered_map<int,int> after ; 
        after.reserve( 2*n ) ; 
        int ans = n ; 
        for( int i=n-1 ; i>=0 ; --i ){
            int r = reverse( nums[i] ) ; 
            if( after.find( r ) != after.end() ){
                ans = min( ans , after[r] - i  ) ; 
            }
            after[ nums[i] ] = i ; 
        }
        return ans == n ? -1 : ans ; 
    }
};