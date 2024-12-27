class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length ; 
        long rs = 1; 
        Stack< int[] > stack = new Stack<>() ;
        stack.add( new int[]{nums[0],1} ) ; 
        for( int i=1 ; i<n ; ++i ){
            int[] curr = new int[]{ nums[i] , 1 } ; 
            while( !stack.isEmpty() && stack.peek()[0] <= nums[i] ){
                if( stack.peek()[0] == nums[i] ){
                    curr[1] += stack.peek()[1] ; 
                }
                stack.pop() ; 
            }
            stack.add( curr ) ; 
            rs += curr[1] ; 
        }
        return rs ;  
    }
}