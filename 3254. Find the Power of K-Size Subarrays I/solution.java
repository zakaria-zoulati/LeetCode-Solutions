class Solution {
    public int[] resultsArray(int[] nums, int k){
        if( k == 1 ){
            return nums ; 
        }
        int n = nums.length ; 
        int[] rs = new int[n-k+1] ; 
        int start = 0 ; 
        int cu = 0 ; 
        for( int i=1 ; i<k ; ++i ){
            if( nums[i] != nums[i-1] + 1 ){
                start = i ; 
            }
        }
        if( start != 0 ){
            rs[0] = -1 ; 
        }else {
            rs[0] = nums[k-1] ; 
        }
        for( int i=k ; i<n ; ++i ){
            if( nums[i] == nums[i-1] + 1 ){
                if( i - start + 1  >= k ){
                    rs[i-k+1] = nums[i] ; 
                }else {
                    rs[i-k+1] = -1  ;
                }
            }else {
                start = i ; 
                rs[i-k+1] = -1 ; 
            }
        }
        return rs ; 
    }
}