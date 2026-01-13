class Solution {
    public int[] arrayChange(int[] nums, int[][] ops) {
        int n = nums.length ; 
        int m = ops.length ; 
        int max = 0 ; 
        int[] mapper = new int[1_000_001] ; 
        for( int i=0 ; i<n ; ++i ){
            mapper[ nums[i] ] = i ; 
        }
        for( int i=0 ; i<m ; ++i ){
            int curr = mapper[ ops[i][0] ] ; 
            mapper[ ops[i][0] ]= -1 ; 
            mapper[ ops[i][1] ] = curr ; 
            nums[curr] = ops[i][1] ; 
        }
        return nums ; 
    }
}