import java.util.* ; 
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int n = nums.length ; 
        Arrays.sort( nums ) ; 
        int d = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            d++ ;
            if(i+1<n && nums[i+1] == nums[i] ){
                while( i+1<n && nums[i+1] == nums[i] ){
                    i++ ; 
                }
            }
        }
        d = Math.min( d , k ) ; 
        int[] rs = new int[d] ; 
        int in = 0 ; 
        for( int i=n-1 ; i>=0 && in <d ; --i ){
            rs[in++] = nums[i] ; 
            while( i-1>=0 && nums[i-1] == nums[i] ){
                i-- ; 
            }
        }
        return rs ; 
    }
}