class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int z1 = 0 ; 
        long sum1 = 0 ;  
        for( int i : nums1 ){
            sum1 += i ;
            if(i==0)++z1 ; 
        }
        int z2 = 0 ; 
        long sum2 = 0 ; 
        for( int i : nums2 ){
            sum2 += i ; 
            if(i==0)++z2 ; 
        }
        if( z1 > 0 && z2 > 0 ){
            return Math.max(sum1+z1 , sum2+z2) ; 
        }else if( z1+z2==0 ){
            return sum1==sum2?sum1:-1 ; 
        }else if( z1 > 0 ){
            return sum1+z1>sum2?-1:sum2 ; 
        }else {
            return sum2+z2>sum1?-1:sum1 ; 
        }
    }
}