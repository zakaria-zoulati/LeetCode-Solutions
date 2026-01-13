class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int rs = 0 ;
        boolean[] flag = new boolean[1001] ; 
        for(int num : nums){
            if( num % 2 == 0 ){
                flag[2] = true ; 
            }
            for(int i=3; i<=num ; i+=2 ){
                if( num % i == 0 ){
                   flag[i] = true ; 
                }
            }
        }
        boolean[] isPrim = new boolean[1001]; 
        for(int i=2 ; i<1001 ; ++i){
            if( isPrim[i] ) continue; 
            isPrim[i] = true ; 
            if( flag[i] ) rs++ ; 
            for(int j=i*i ; j<1001 ; j+=i){
                isPrim[j] = true ; 
            }
        }

       return rs ; 

    }
}