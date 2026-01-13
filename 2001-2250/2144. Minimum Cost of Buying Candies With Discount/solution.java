class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost) ;  
        int n = cost.length ; 
        int rs = 0 ; 
        for(int i=n-1 ; i>=0 ; i-- ){
            rs += cost[i--] ; 
            if( i>=0 ){
                rs += cost[i--] ; 
            } 
        }
        return rs ; 
    }
}