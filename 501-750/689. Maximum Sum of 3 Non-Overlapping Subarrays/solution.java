class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length ; 
        int[] rs = new int[3] ; 
        int[] suff = new int[n]; 
        int[] best_left = new int[n] ; 
        best_left[n-k] = n-k ; 
        int val = 0 ; 
        for( int i=n-1 ; i>=n-k ; --i ){
            val += nums[i] ; 
        }
        suff[n-k] = val ; 
        int best = val ;
        int in = n-k ;  
        for( int i=n-k-1 ; i>=0 ; --i ){
            val += nums[i] - nums[i+k] ;
            suff[i] = val ;  
            if( val >= best  ){
                best = val ; 
                in = i ; 
            }
            best_left[i] = in ;
        }

        int start = 0 ; 
        int front = 0 ;
        for( int i=0 ; i<k ; ++i ){
            front += nums[i] ; 
        }
        best = front ; 
        rs[0] = 0 ; 
        rs[1] = k ; 
        rs[2] = best_left[2*k] ;
        int sum = suff[0] + suff[k] + suff[ rs[2] ] ; 
        for( int i=k+1 ;i+2*k<n+1 ; ++i ){
            front += nums[i-1] - nums[i-k-1] ; 
            if( front > best ){
                best = front ; 
                start = i-k ; 
            }
            int mid = best + suff[i] + suff[ best_left[i+k] ] ; 
            if( mid > sum ){
                sum = mid ; 
                rs[0] = start ; 
                rs[1] = i ; 
                rs[2] = best_left[i+k] ; 
            } 
        }
        return rs ; 
    }
}