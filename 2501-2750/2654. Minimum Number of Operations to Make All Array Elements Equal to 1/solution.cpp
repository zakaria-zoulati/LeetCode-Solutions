class Solution {
    int gcd( int a , int b ){
        while( b != 0 ){
            int temp = a%b ; 
            a = b ; 
            b = temp ; 
        }
        return a ; 
    }
    public int minOperations(int[] nums) {
        int n = nums.length ; 
        int ones = 0 ; 
        int g = 0 ; 
        for( int num : nums ) {
            if( num == 1 ) ones++ ; 
            g = gcd( g , num ) ; 
        }
        if( ones > 0 ) return n - ones ; 
        if( g != 1 ) return -1 ;  
        int len = n ; 
        for( int i=0 ; i<n ; ++i ){
            int curr = nums[i] ; 
            for( int j=i ; j<n ; ++j ){
                curr = gcd( curr , nums[j] ) ; 
                if( curr == 1 ){
                    len = Math.min( len , j-i+1 ) ; 
                    break ;   
                }
            }
        }
        return ( n-1 ) + ( len - 1 ) ;  
    }
}