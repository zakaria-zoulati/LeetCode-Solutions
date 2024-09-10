class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length ; 
        if( n == 1 ) return false ; 
        HashSet<Integer> set = new HashSet<>() ; 
        nums[0] %= k ; 
        nums[1] = (nums[0] + nums[1] )%k ; 
        set.add( 0 );
        set.add( nums[0] ) ; 
        if( nums[1] == 0  ) return true ; 
        for(int i=2 ; i<n ; ++i){
            set.add( nums[i-2] ) ;
            nums[i] = ( nums[i] + nums[i-1] )%k ; 
            if(  set.contains( nums[i] ) ) return true ;
        }
        return false ; 
    }
}