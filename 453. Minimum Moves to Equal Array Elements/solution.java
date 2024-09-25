class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length ; 
        int sum = 0 ; 
        int min = Integer.MAX_VALUE ; 
        for(int num : nums){
            sum += num ; 
            if( num < min ){
                min = num ; 
            }
        }
        int rs = sum -n*min ; 
        return rs ; 
    }
}