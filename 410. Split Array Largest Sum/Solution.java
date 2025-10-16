class Solution {
    public boolean check( int[] nums , int n , int k , int tar ){
        int parts = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] > tar ) return false ; 
            int curr = nums[i] ; 
            while( i+1<n && curr+nums[i+1] <= tar ){    
                i++ ; 
                curr += nums[i] ; 
            }
            parts++ ; 
        }
        if( parts > k ) return false ; 
        return true ; 
    }
    public int splitArray(int[] nums, int k) {
        if( k == 1 ){
            int sum = 0 ; 
            for( int num : nums ){
                sum += num ; 
            }
            return sum ; 
        }else {
            int l = 0 ; 
            int r = 1_000_000_000 ; 
            while( l < r ){
                int mid = l + ( r - l )/2; 
                if( check( nums , nums.length , k , mid ) ){
                    r = mid ; 
                }else {
                    l = mid + 1 ; 
                }
            }
            return l ; 
        }
    }
}