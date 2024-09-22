class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int rs = 0 ; 
        boolean[] isSeen = new boolean[1001] ;  
        int product = 1 ; 
        for(int num : nums){
            if( num % 2 == 0 ){
                isSeen[2] = true ; 
            }
            for(int i=3 ; i<1001 ; i+=2 ){
                if( num % i == 0 ){
                    isSeen[i] = true; 
                }
            }
            
        }

        boolean isPrime[] = new boolean[1001] ; 
        for(int i=2 ; i<1001 ; ++i ){
            if( isPrime[i]  ) continue ; 
            if( isSeen[i]  ) rs++ ; 
            for(int j = i*i ; j<1001 ; j+=i ){
                isPrime[j] = true ;
            }
        }

        return rs ; 
    }
}