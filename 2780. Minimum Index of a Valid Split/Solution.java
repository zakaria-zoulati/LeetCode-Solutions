class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(); 
        int maj = -1 ; 
        int count = 0 ; 
        for( int i : nums ){
            if( count == 0 ){
                maj = i ; 
                count++ ; 
            }else if( i == maj ){
                count++ ; 
            }else {
                count-- ; 
            }
        }
        int fre = 0 ; 
        for( int i : nums ){
            if( i == maj ) fre++ ; 
        }
        if( 2*fre <= n ) return -1 ;
        int curr = 0; 
        for (int i = 0; i < n; ) {
            if (nums.get(i) == maj) curr++; 
            i++ ; 
            if (2 * curr > i  && 2 * (fre - curr) > n - i ) {
                return i-1; 
            }
        }
        return -1; 
    }
}
