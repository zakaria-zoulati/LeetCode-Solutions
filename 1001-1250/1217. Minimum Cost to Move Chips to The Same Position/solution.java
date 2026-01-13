class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length ; 
        int one = 0  ; 
        int two = 0 ; 
        for(int num : position ){
            if( ( num - 1) % 2==0 ){
                two++; 
            }
            else {
                one++ ; 
            
        }
        return Math.min( one , two ) ; 

    }
}