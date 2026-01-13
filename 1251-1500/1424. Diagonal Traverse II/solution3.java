class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size() ; 
        int len = 0 ; 
        int max = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            len += nums.get(i).size() ; 
            max = Math.max( max , i+nums.get(i).size() ) ;
        }
        int[] rs = new int[len] ;
        Stack<Integer>[] stacks = new Stack[max] ;
        for( int i=0 ; i<max ; ++i ){
            stacks[i] = new Stack<>() ; 
        } 
        int in = 0; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<nums.get(i).size() ; ++j ){
                stacks[i+j].add( nums.get(i).get(j) ) ; 
            }
        }
        for( int i=0 ; i<max ; ++i ){
            while( !stacks[i].isEmpty() ){
                rs[in++] = stacks[i].pop() ; 
            }
        }
        return rs ; 
    }
}