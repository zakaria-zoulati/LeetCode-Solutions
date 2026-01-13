class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs) ; 
        int rs = 0;  
        for(int num : costs){
            if( num <= coins ){
                rs++ ; 
                coins -= num ; 
            }else break ;
        }
        return rs ; 
    }
}