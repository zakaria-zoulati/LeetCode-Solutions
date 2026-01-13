class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length ; 
        int[] rs = new int[n] ; 
        Stack<int[]> stack = new Stack<>() ; 
        stack.add( new int[]{ temperatures[n-1] ,n-1 } ) ; 
        for( int i=n-2 ; i>=0 ; --i ){
            while( !stack.isEmpty() && temperatures[i] >= stack.peek()[0] ){
                stack.pop() ; 
            } 
            if( !stack.isEmpty() ){
                rs[i] = stack.peek()[1] - i ; 
            }
            stack.add( new int[]{ temperatures[i] , i } ) ; 
        }
        return rs ; 
    }
}