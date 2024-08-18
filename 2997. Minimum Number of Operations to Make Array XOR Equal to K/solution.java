class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length ; 
        int all = 0 ; 
        for(int i=0 ; i<n ; ++i){
            all ^= nums[i] ;
        }
        int rs =0 ;
        int inter = all^k ; 
        while( inter != 0  ){
            if( inter%2 ==1 ) rs ++ ; 
            inter /= 2 ;
        }

        return rs ; 

    }
}