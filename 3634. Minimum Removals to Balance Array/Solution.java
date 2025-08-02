class Solution {
    public int minRemoval(int[] nums, int k) {
         int n = nums.length ; 
         if( n == 1 ) return 0 ; 
         int rs = n+1 ; 
         Arrays.sort( nums ) ;
         long kk = k ; 
         for( int i=0 ; i<n ; ++i ){
             if(  nums[i]*kk >=  nums[n-1] ){
                 rs = Math.min( rs , i ) ; 
                 break ; 
             }else{
                 int l = i ; 
                 int r = n-1 ; 
                 while( l < r ){
                     int mid = l + ( r- l + 1 )/2 ; 
                     if( nums[i]*kk >= nums[mid] ){
                         l = mid ;
                     }else {
                         r = mid -1 ; 
                     }
                 }
                 rs = Math.min( rs , i + n-1-l ) ; 
             }
         }
        return rs ; 
    }
}