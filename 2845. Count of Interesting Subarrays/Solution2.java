import java.util.List;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size() ; 
        if( k > n ){
            return 0 ; 
        }
        long rs = 0 ; 
        int count = 0 ; 
        int[] map = new int[n+1] ; 
        map[0] = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums.get(i) % modulo == k ){
                count = ( count + 1 ) % modulo ; 
            }
            int ele = ( count - k + modulo ) % modulo ; 
            if( ele <= n ){
                rs += map[ele] ; 
            }
            map[ count ]++ ; 
        }
        return rs ; 
    }
}