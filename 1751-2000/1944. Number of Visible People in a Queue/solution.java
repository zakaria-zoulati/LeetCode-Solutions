class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length ; 
        int[] rs = new int[n] ; 
        Stack<Integer> stack = new Stack<>() ; 
        stack.add( heights[n-1] ) ; 
        for( int i=n-2 ; i>=0 ; --i ){ 
            if( heights[i] <= stack.peek() ){
                rs[i] = 1 ;
            }else {
                while( !stack.isEmpty() && stack.peek() <= heights[i] ){
                    stack.pop() ; 
                    rs[i]++ ; 
                }
                if( !stack.isEmpty() ){
                    rs[i]++ ; 
                }
            }
            stack.add( heights[i] ) ; 
        }
        return rs ; 
    }
}