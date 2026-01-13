class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length ;
        boolean[] isPrime = new boolean[1001] ; 
        for(int i=2 ; i<=1000 ; ++i){
            if( isPrime[i] ) continue ; 
            for( int j=i*i ; j<=1000 ; j += i ){
                isPrime[j] = true ; 
            }
        }
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i] < nums[i+1] ) continue ; 
            for(int j=2 ; j<nums[i] ; ++j ){
                if( !isPrime[j] && nums[i]-j < nums[i+1] ){
                    nums[i] -= j ; 
                    break ; 
                }
            } 
            if( nums[i] >= nums[i+1] ) return false  ; 
        }
        return true ; 
    }
}