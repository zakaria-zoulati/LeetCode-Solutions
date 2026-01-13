class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int n = nums1.length ; 
       int m = nums2.length ; 
       int[] next = new int[10001] ; 
       for(int i=0; i<m ; ++i){
            for(int j=i+1 ; j<m ; ++j ){
                if( nums2[j] > nums2[i] ){
                    next[ nums2[i] ] = nums2[ j ] ; 
                    break ; 
                }
            }
       }
       for( int i=0 ; i<n ; ++i ){
            if( next[ nums1[i] ] == 0 ){
                nums1[i] = -1; 
            }else {
                nums1[i] = next[ nums1[i] ] ;
            }
       }
       return nums1 ;
    }
}