class Solution {
    public boolean isPrime(int  n) {
        if (n <= 1) {
            return false; 
        }
        if (n <= 3) {
            return true; 
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; 
        }
        
        for (int  i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false; 
            }
        }
        return true; 
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length ; 
        int max  = 0 ; 
        for(int i= 0 ; i<n ; ++i){
            if( isPrime( nums[i][i] ) ){
                max = Math.max( max, nums[i][i] )   ;
            }
            if( isPrime( nums[n-1-i][i] ) ){
                max = Math.max( max, nums[n-1-i][i] )   ;
            }
        }
        return max ; 
    }
}