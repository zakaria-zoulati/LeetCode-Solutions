class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int m = nums2.length ;
        int rs = 0 ; 
        if( m%2 == 1 ){
            for( int num : nums1 ){
                rs ^= num ; 
            }
        }
        if( n%2 == 1 ){
            for( int num : nums2 ){
                rs ^= num ; 
            }
        }
        return rs ; 

    }
}