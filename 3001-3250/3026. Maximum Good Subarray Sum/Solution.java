class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length ; 
        long rs = Long.MIN_VALUE ; 
        long sum = 0L ; 
        Map< Long , Long > map = new HashMap<>(n) ;  
        map.put( (long) nums[0] , 0L ) ; 
        sum = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            long first = nums[i] - k ; 
            Long f = map.get( first ) ; 
            if( f != null ){
                rs = Math.max( rs , sum + nums[i] - f ) ; 
            }
            long second = nums[i] + k ; 
            Long s = map.get( second ) ; 
            if( s != null ){
                rs = Math.max( rs , sum + nums[i] - s ) ; 
            }

            Long curr = map.get( (long) nums[i] ) ; 
            if( curr  == null ){
                map.put( (long) nums[i] , sum ) ; 
            }else if( sum < curr ){
                map.put( (long) nums[i] , sum ) ; 
            }
            sum += nums[i] ;
        }
        return rs == Long.MIN_VALUE ? 0 : rs ; 
    }
}