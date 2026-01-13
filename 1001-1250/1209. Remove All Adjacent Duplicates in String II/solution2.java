class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>() ; 
        for( char c : s.toCharArray() ){
            if( stack.isEmpty() || stack.peek()[0] !=  c - 'a'   ){
               int[] pair = new int[2] ; 
               pair[0] = c - 'a' ;  
               pair[1] = 1 ; 
               stack.push( pair ) ; 
            }else if( stack.peek()[1] == k-1  ){
                stack.pop() ; 
            }else {
                stack.peek()[1]++ ; 
            }
        } 
        StringBuilder rs = new StringBuilder() ; 
        while( !stack.isEmpty() ){
            int[] curr = stack.pop() ; 
            char c = (char) ( 'a' + curr[0] ) ; 
            for(int i=0 ; i<curr[1] ; ++i){
                rs.append( c ) ; 
            }
        }
        return rs.reverse().toString() ; 
    }
}