class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>() ; 
        for( char c : s.toCharArray() ){
            if( !stack.isEmpty() && c == 'B' ){
                if( stack.peek() == 'A' ) stack.pop() ; 
                else stack.push( c ) ; 
            }else if( !stack.isEmpty() && c == 'D' ){
                if( stack.peek() == 'C' ) stack.pop() ; 
                else stack.push(c) ; 
            }else {
                stack.push( c ) ; 
            }
        }
        return stack.size() ; 
    }
}