class Solution {
    static class BIT {
        int[] arr ;
        public BIT(int n){
            this.arr = new int[n+1] ; 
        }
        public void update( int val ){
            val++ ; 
            while( val < arr.length ){
                arr[val] += 1 ; 
                val += ( val & -val ) ; 
            }
        }
        public int sum( int val ){
            val++ ; 
            int rs = 0 ;
            while( val > 0 ){
                rs += arr[val] ; 
                val -= ( val & -val ) ; 
            }
            return rs ; 
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length ; 
        int[][] map = new int[n][2] ;
        for( int i=0 ; i<n ; ++i ){
            map[i][0] = i ; 
            map[i][1] = nums[i] ; 
        }
        Arrays.sort( map , (a,b) -> a[1]-b[1] ) ; 
        int start = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            nums[ map[i][0] ] = start ; 
            while( i+1<n && map[i+1][1] == map[i][1] ){
                i++  ;
                nums[ map[i][0] ] = start ; 
            }
            start++ ; 
        }
        BIT bit = new BIT( start ) ; 
        Integer[] rs = new Integer[n] ;
        bit.update( nums[n-1] ) ; 
        rs[n-1] = 0 ; 
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i+1] == nums[i] ){
                rs[i] = rs[i+1] ; 
            }else if( nums[i+1] > nums[i] && rs[i+1] == 0 ){
                rs[i] = 0 ; 
            }else {
                rs[i] = bit.sum( nums[i] - 1 ) ; 
            }
            bit.update( nums[i] ) ; 
        }
        return Arrays.asList( rs ) ; 
    }
}