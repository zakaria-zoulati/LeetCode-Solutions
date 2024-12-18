class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ;
        int tar = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] == tar ){
                ++rs ;
                while(i+1<n && nums[i+1] == tar){
                    ++i ; 
                }
                tar=1-tar ; 
            }else {
                while( i+1 <n && nums[i+1] == 1-tar){
                    ++i ; 
                }
            }
        }
        return rs ; 
    }
}