class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length ; 
        int rs = 0; 
        Stack<Integer> stack = new Stack<>() ; 
        for(int i = 0 ; i<n ; ++i){
            if( stack.isEmpty() || nums[stack.peek()] > nums[i] ){
                stack.push( i ) ; 
            }
        }
        for(int i=n-1 ; i>=0 ; --i){
            while( !stack.isEmpty() && nums[stack.peek()] <= nums[i] ){
                rs = Math.max( i - stack.pop() , rs ) ; 
            }
        }

        return rs ; 
       
    }
}