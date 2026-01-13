class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ; 
        int current = 0 ; 
        Arrays.sort( nums ) ; 
        for(int i=0; i<n ; ++i){
            if( nums[i] != 0 && nums[i] > current ){
                current += nums[i] - current ; 
                rs++ ; 
            }
        }
        return rs ;
    }
}