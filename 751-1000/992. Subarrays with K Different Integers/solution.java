class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n =  nums.length ;
        int rs = 0 ; 
        int count = 0 ; 
        int[] f = new int[n+1] ; 
        int start = 0 ; 
        int prev = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            if( f[nums[i]]++ == 0 ){
                count++ ; 
            }
            if( count == k ){ 
                while( f[ nums[start] ] > 1 ){
                    prev++ ; 
                    f[ nums[ start++ ] ]-- ; 
                }
                rs += prev ; 
                continue ; 
            }
            else if( count > k ){
                while( true ){
                    if( f[ nums[start++] ]-- == 1 ){
                        count-- ; 
                        break ; 
                    }
                }  
                prev = 1 ; 
                while( f[ nums[start] ] > 1 ){
                    f[ nums[start++] ]-- ; 
                    prev++ ; 
                }
                rs += prev ; 
            }
        }
        return rs ; 
    }
}