class Solution {
    int getLen( int[] nums , int k ){
        int ans = 0 ; 
        for( int num : nums ){
            ans = Math.max( ans , num ) ; 
        }
        return ans + k+1 ; 
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length ; 
        int len = getLen(nums,k) ; 
        int[] f = new int[len] ; 
        int[] diff = new int[len] ; 
        for( int num : nums ){
            f[num]++ ; 
            int l = Math.max( num - k , 0 ) ; 
            diff[l]++ ; 
            int r = num + k + 1 ; 
            if( r < len ) diff[r]-- ; 
        }
        int ans = 0 ; 
        for( int i=1 ; i<len ; ++i ){
            diff[i] += diff[i-1] ; 
            int curr = f[i] ; 
            curr += Math.min( numOperations , diff[i] - f[i] ) ; 
            ans = Math.max( ans , curr ) ; 
        }
        return ans ;
    }
}