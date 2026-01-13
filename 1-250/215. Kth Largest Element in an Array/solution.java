class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] inter = new int[ 20001 ] ;        
        for (int num : nums) {
           inter[ num + 10000 ]++ ; 
        }

        for(int i= 20000 ; i>=0 ; --i  ){
            if( inter[i] == 0  ) continue  ;
            if( inter[i] <  k ){
                k -= inter[i] ; 
            }else {
                return i - 10000 ; 
            }
        }
        return -1 ;
    }
}
