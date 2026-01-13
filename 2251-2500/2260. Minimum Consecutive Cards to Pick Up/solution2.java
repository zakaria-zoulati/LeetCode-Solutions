import java.util.* ; 
class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length ; 
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        int rs = Integer.MAX_VALUE ; 
        for(int i=0 ; i<n ; ++i){
            Integer val = map.get( cards[i] ) ; 
            if( val == null  ){
                map.put( cards[i] , i ) ; 
            }else {
                rs = Math.min( rs , i - val +1 ) ;
                map.put( cards[i] , i  ) ; 
            }
        }
        if( rs == Integer.MAX_VALUE ){
            return -1 ; 
        }else {
            return rs ; 
        }
    }
}