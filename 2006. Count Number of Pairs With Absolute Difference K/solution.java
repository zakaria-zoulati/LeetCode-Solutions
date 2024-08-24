class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] inter = new int[101] ; 
        int rs = 0 ; 
        for( int num : nums ){
            inter[num]++ ;
        }
        for(int i=0 ; i+k<101 ; ++i ){
            rs += inter[i]*inter[i+k] ; 
        }
        return rs ;
    }
}