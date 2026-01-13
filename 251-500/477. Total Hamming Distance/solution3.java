class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length ; 
        int[] arr = new int[32] ; 
        int rs = 0 ; 
        for(int num : nums ){
            int j = 0 ; 
            while( num  > 0 ){
                if( (num & 1 ) == 1 ){
                    ++arr[j] ; 
                }
                j++ ; 
                num >>= 1 ; 
            }
        }
        for( int num : arr ){
            rs += num * ( n - num ) ; 
        }
        return rs ; 
    }
}