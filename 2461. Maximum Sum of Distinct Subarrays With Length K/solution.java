class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length ; 
        long rs = 0 ; 
        long max = 0 ; 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        for(int i=0 ; i<k ; i++){ 
            map.put( nums[i] , map.getOrDefault( nums[i] ,0 )+1 ) ; 
            max += nums[i] ; 
        }
        if( map.size() == k  ){
            rs = max ; 
        }
        for(int i=1 ; i+k<=n ; i++ ){
            if( nums[i-1] ==  nums[i+k-1] ){
                continue  ; 
            }
            max -= nums[i-1] ; 
            max += nums[i+k-1] ; 
            int current = map.get( nums[i-1]) ;
            map.put( nums[i-1] , current -1 ) ;   
            map.put( nums[i+k-1] , map.getOrDefault( nums[i+k-1] , 0 ) +1 ) ; 
            if( current == 1  ){
                map.remove( nums[i-1] ) ; 
            } 
            if( map.size() == k ){
                rs = Math.max( max , rs ) ; 
            }
        }
        return rs ; 
    }
}