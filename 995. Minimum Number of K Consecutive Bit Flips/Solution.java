class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length ; 
        if( k == 1 ){
            int ans = n ; 
            for( int num : nums ) ans -= num ;  
            return ans ; 
        }else if( k == n ){
            int sum = 0 ; 
            for( int num : nums ) sum += num ; 
            if( sum == 0 ) return 1 ; 
            if( sum == n ) return 0 ; 
            return -1 ; 
        }else {
            int ans = 0; 
            int[] f = new int[n] ; 
            if( nums[0] == 0 ){
                f[0] = 1 ; 
                f[k] = -1 ;
                ans++ ; 
            }
            for( int i=1 ; i<=n-k ; ++i ){
                f[i] += f[i-1] ; 
                if( nums[i] == (f[i]&1) ){
                    ans++ ; 
                    f[i]++ ; 
                    if( i + k < n ) f[i+k]-- ; 
                }
            }
            for( int i=n-k+1 ; i<n ; ++i ){
                f[i] += f[i-1] ; 
                if( nums[i] == f[i]%2 ){
                    return -1 ; 
                }
            }
            return ans ; 
        }
    }
}