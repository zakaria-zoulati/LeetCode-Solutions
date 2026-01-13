class Solution {
    public int maxOperations(int[] nums, int k) {
       int rs = 0 ; 
       HashMap<Integer , Integer> map = new HashMap<>() ; 
       for( int num : nums ){
            if( num >= k ) continue ; 
            map.put( num , map.getOrDefault( num , 0 )+ 1 ) ; 
       }
       for( int key : map.keySet() ){
            rs += Math.min( map.get(key) , map.getOrDefault(k-key , 0) ) ; 
       }
       return rs/2 ; 
    }
}