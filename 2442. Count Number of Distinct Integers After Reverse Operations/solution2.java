class Solution {
    public int rev( int n ){
        int rs = 0 ; 
        while( n > 0 ){
            rs = rs*10 + n%10 ; 
            n /= 10 ;
        }
        return rs ; 
    }
    public int countDistinctIntegers(int[] nums) {
        boolean[] x = new boolean[1_000_001] ; 
        int rs = 0 ; 
        for(int num : nums){
            if( !x[num] ){
                ++rs ; 
                x[num] = true ; 
            }
            int r = rev(num); 
            if( !x[r] ){
                ++rs ; 
                x[r] = true ; 
            } 
        }
        return rs ; 
    }
}