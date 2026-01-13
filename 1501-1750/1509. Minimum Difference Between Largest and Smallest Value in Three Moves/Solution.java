class Solution {
    public void updateMin( int[] min , int val ){
        int curr = val ; 
        for( int i=0 ; i<4 ; ++i ){
            if( val < min[i] ){
                int temp = min[i] ; 
                min[i] = val ; 
                val = temp ; 
            }
        }
    }
    public void updateMax( int[] max , int val ){
        int curr = val ; 
        for( int i=3 ; i>=0 ; --i ){
            if( val > max[i] ){
                int temp = max[i] ; 
                max[i] = val ; 
                val = temp ; 
            }
        }
    }
    public int minDifference(int[] nums) {
        int n = nums.length ; 
        if ( n <= 3 ){
            return 0 ; 
        }
        int[] min = new int[4] ; 
        int[] max = new int[4] ; 
        for( int i=0 ; i<4 ; ++i ){
            min[i] = Integer.MAX_VALUE ; 
            max[i] = Integer.MIN_VALUE ; 
        }
        for( int i : nums ){
            updateMin( min , i ) ; 
            updateMax( max , i ) ; 
        }
        int rs = Integer.MAX_VALUE ; 
        for( int i=0 ; i<4 ; ++i ){
            rs = Math.min( rs , max[i] - min[i] ) ; 
        }
        return rs ; 
    }
}