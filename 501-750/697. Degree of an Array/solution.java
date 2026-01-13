class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[] > map = new HashMap<>() ; 
        int max = 0 ; 
        int i=0 ; 
        for(int num : nums){
            i++ ; 
            if( map.get( num ) == null ){
                map.put( num , new int[3] ); 
                map.get(num)[0] = 1 ;
                map.get(num)[1] = i  ;
            }else {
                map.get(num)[0]++ ; 
                map.get(num)[2] = i ;
            }
            max = Math.max( max , map.get(num)[0] ) ; 
        }
        if( max == 1 ) return 1; 
        int rs = Integer.MAX_VALUE ;  
        for( int item : map.keySet() ){
            if(  map.get(item)[0] == max ){
                rs = Math.min( rs  , map.get(item)[2] - map.get(item)[1] +1 ) ; 
            }
        }
        return rs ;  
    }
}