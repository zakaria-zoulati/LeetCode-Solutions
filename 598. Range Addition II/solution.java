class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int len = ops.length ;
        int a = m ; 
        int b = n ; 
        for(int i=0 ; i<len ; ++i){
            a = Math.min( a , ops[i][0] ) ;
            b = Math.min( b , ops[i][1] ) ;
        }
        return a*b ; 
    }
}