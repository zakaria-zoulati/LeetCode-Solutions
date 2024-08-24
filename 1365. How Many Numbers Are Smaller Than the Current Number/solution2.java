class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        int[] inter = new int[101] ; 
        for( int num : nums ){
            inter[ num ]++ ;
        }
        for(int i=1 ; i<101 ; ++i){
            inter[i] += inter[i-1] ; 
        }
        for(int i=0 ; i<n ; ++i){
            if( nums[i] == 0 ){
                rs[i] = 0 ; 
            }else{
                rs[i] = inter[ nums[i] - 1 ] ;
            }
        }
        return rs ; 
    }
}