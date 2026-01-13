class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0 ; 
        for( int num : nums ){
            sum += num ; 
        }
        long target = sum % p ; 
        if( target == 0 ) return 0 ; 

        int n = nums.length ; 
        int ans = n ; 
        long curr = 0 ;
        Map<Long,Integer> m = new HashMap<>() ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] % p == target ) return 1 ;
            curr = ( curr + nums[i] ) % p ; 
            
            if( curr == target ){
                ans = Math.min( ans , i+1 ) ;  
            }

            long prev = ( curr - target + p ) % p ; 
            if( m.get( prev ) != null ){
                ans = Math.min( ans , i - m.get(prev) ) ; 
            }

            m.put( curr , i ); 
        }

        return ans == n ? - 1 : ans ; 
    }
}