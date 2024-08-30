class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int max1 = 0 ;
        int max2 = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            max1 = Math.max( nums1[i] , max1 ) ; 
            max2 = Math.max( nums2[i] , max2 ) ; 
        }
        return max2 - max1 ; 
    }
}