class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE ; 
        int max = Integer.MIN_VALUE ; 
        int a = 0 ; 
        int b = 0 ; 
        int n = nums.length ; 
        if( n<=2){
            return n ; 
        } 
        for(int i=0 ; i<n ; ++i){
            if( nums[i] < min ){
                min = nums[i] ; 
                a = i ;
            }
            if( nums[i] > max ){
                max = nums[i] ; 
                b = i ;
            }
        }
        int rs = Math.min(  n - Math.min(a,b) , Math.max(a,b) +1 ) ;
        rs = Math.min( rs , n-b + a+1 ) ;
        rs = Math.min( rs , n-a + b+1  ) ;
        return rs ;
    }
}