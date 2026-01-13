class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length ; 
        int m = nums[0].length ; 
        int rs = 0 ; 
        for( int[] i : nums ){
            Arrays.sort(i) ; 
        }
        while( m-- > 0 ){
            int ele = 0 ; 
            for( int i=0 ; i<n ; ++i ){
                ele = Math.max( ele , nums[i][m] ) ; 
            }
            rs += ele ; 
        }
        return rs ; 
    }
}