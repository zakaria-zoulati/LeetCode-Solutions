class Solution {
    public int gcd( int x , int y ){
        while( y != 0  ){
            int temp = x ; 
            x = y ; 
            y = temp % y ;  
        }
        return x ; 
    }
    public int minOperations(int[] nums, int[] e) {
        int n = nums.length ; 
        int m = e.length ; 
        int curr = e[0] ; 
        for(int num : e ){
            curr = gcd( curr , num ) ; 
        }
        Arrays.sort( nums ) ; 
        int rs = 0 ; 
        while( rs <n && curr%nums[rs] != 0 ){
            while( rs+1<n && nums[rs+1] == nums[rs] ){
                rs++ ;
            }
            rs++ ; 
        }
        if( rs == n ) return -1  ;
        return rs ;
    }
}