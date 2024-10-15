class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length/3 ; 
        Arrays.sort( nums ) ; 
        int[][] rs = new int[n][3] ; 
        for(int i=0 ; i<n ; ++i){
            if( nums[i*3+2] - nums[i*3] > k ){
                return new int[0][0]; 
            }
            rs[i][0] = nums[ i*3 ] ; 
            rs[i][1] = nums[ i*3 + 1 ] ; 
            rs[i][2] = nums[ i*3 + 2 ] ; 
        }
        return rs ; 
    }
}