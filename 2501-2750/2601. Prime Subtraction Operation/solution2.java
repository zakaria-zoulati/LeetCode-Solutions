class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length ;
        int max = 0 ; 
        for(int i : nums){
            max = Math.max( max , i ) ; 
        }
        boolean[] isPrime = new boolean[max+1] ; 
        for(int i=2 ; i<=max ; ++i){
            if( isPrime[i] ) continue ; 
            for( int j=i*i ; j<=max ; j += i ){
                isPrime[j] = true ; 
            }
        }
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i] < nums[i+1] ) continue ; 
            for(int j=2 ; j<nums[i] ; ++j ){
                if( !isPrime[j] && nums[i]-j<nums[i+1] ){
                    nums[i] -= j ; 
                    break ; 
                }
            } 
            if( nums[i]>=nums[i+1] )return false; 
        }
        return true ; 
    }
}