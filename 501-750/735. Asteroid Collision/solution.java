class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>() ; 
        int n = asteroids.length ; 
        all : for(int i=n-1 ; i>=0 ; --i ){
            if( asteroids[i] > 0 ){
                while( stack.size() > 0  ){
                    int curr = stack.peek() ; 
                    if( curr == -asteroids[i] ){
                        stack.pop() ; 
                        continue all ; 
                    }
                    if( curr > 0 ){
                        stack.add( asteroids[i] ) ; 
                        break ; 
                    }else {
                        curr = -curr ; 
                        if( asteroids[i] < curr ) break ; 
                        else stack.pop() ; 
                    }
                }
                if( stack.size() == 0 ){
                    stack.add( asteroids[i] ) ; 
                }
            }else {
                stack.add( asteroids[i] ) ; 
            }
        }

        int[] rs = new int[ stack.size() ] ; 
        int i = 0 ; 
        while( !stack.isEmpty() ){
            rs[ i++ ] = stack.pop() ; 
        }
        return rs ; 
    }
}