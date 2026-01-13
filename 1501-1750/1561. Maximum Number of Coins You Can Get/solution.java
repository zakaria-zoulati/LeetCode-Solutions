class Solution {
    public int maxCoins(int[] piles) {
        int rs = 0 ;
        Arrays.sort(piles) ; 
        int n = piles.length ; 
        int left = 0 ; 
        for(int i=n-2 ; i>=0 && left < i ; i -= 2  ){
            rs += piles[i] ;
            ++left ;
        }
        return rs ; 
    }
}