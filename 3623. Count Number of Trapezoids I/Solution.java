class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length ;
        int mod = 1_000_000_007 ; 
        long prev = 0 ; 
        long ans = 0 ;
        Map<Integer,Long> lines = new HashMap<>(); 
        for( int[] pt : points ) lines.put( pt[1] , lines.getOrDefault( pt[1] , 0L ) + 1L ) ; 
        for( Long line : lines.values() ){
            long curr = line*(line-1) >> 1  ; 
            ans = ( ans + curr*prev ) ; 
            prev = ( prev + curr ) ; 
        }
        return (int) (ans % mod); 
    }
}