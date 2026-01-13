class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length() ; 
        if( n == k ){
            return "0" ; 
        }
        Stack<Integer> stack = new Stack<>();  
        int count = 0 ; 
        stack.add( num.charAt(0) - '0' ) ; 
        for( int i=1 ; i<n ; ++i ){
            int curr = num.charAt(i) - '0' ; 
            while( !stack.isEmpty() && count < k && stack.peek() > curr  ){
                stack.pop() ;
                count++ ; 
            }
            stack.add( curr ) ; 
        }
        while( count < k ){
            stack.pop() ;
            count++ ; 
        }
        StringBuilder rs = new StringBuilder() ;
        while( !stack.isEmpty() ){
            rs.append( stack.pop() ) ;
        }
        String res = rs.reverse().toString() ;  
        int j = 0 ;
        while( j<res.length() && res.charAt(j) == '0' ){
            ++j ; 
        }
        if( j == res.length() ){
            return "0" ; 
        }
        return res.substring( j , res.length() ) ; 
    }
}