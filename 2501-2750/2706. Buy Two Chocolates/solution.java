class Solution {
    public int buyChoco(int[] prices, int money) {
        int p1 = Integer.MAX_VALUE ; 
        int p2 = Integer.MAX_VALUE ; 
        for( int p : prices ){
            if( p < p1 ){
                p2 = Math.min( p1 , p2 ) ;
                p1 = p ;   
            }else if( p < p2 ){
                p2 = p ; 
            }
        }
        if( p1 + p2 > money  ){
            return money ; 
        }
        return money - p1 - p2 ;
    }
}