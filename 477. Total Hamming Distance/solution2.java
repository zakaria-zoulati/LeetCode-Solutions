class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length ; 
        int[] arr = new int[32] ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            int j = 0 ; 
            while( nums[i] > 0  ){
                if( (nums[i] & 1 ) == 1 ){
                    ++arr[j] ; 
                }
                j++ ; 
                nums[i] >>= 1 ; 
            }
        }
        for( int num : arr ){
            rs += num * ( n - num ) ; 
        }
        return rs ; 
    }
}