class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length ; 
        if( n < 3 ) return false ; 
        int first = Integer.MAX_VALUE;
        int second = first ; 

        for (int i = 0 ; i<n ; ++i) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i] ;
            } else {
                return true;
            }
        }
        return false;
    }
}
