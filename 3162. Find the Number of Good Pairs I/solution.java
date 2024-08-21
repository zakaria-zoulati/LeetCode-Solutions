class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int rs = 0 ;  
        for(int a : nums1 ){
            if( a % k !=0 ) continue; 
            for(int b : nums2  ){
                if( a % ( b*k ) == 0  ) ++rs ; 
            }
        }
        return rs ; 
    }
}