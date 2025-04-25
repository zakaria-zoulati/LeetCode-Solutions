class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size() ; 
        long rs = 0 ; 
        int count = 0 ; 
        HashMap<Integer,Integer> map = new HashMap<>( ) ;  
        map.put( 0 , 1 ) ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums.get(i) % modulo == k ){
                count = ( count + 1 ) % modulo ; 
            }
            int ele = ( count - k + modulo ) % modulo ; 
            rs += map.getOrDefault( ele , 0 ) ; 
            map.put( count , map.getOrDefault(count , 0) + 1 ) ; 
        }
        return rs ; 
    }
}