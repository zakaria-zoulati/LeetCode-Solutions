class Solution {
    public int maximumLength(int[] nums) {
        int odds = 0 ; 
        int a = 0 ; 
        int b = 0 ;  
        for( int num : nums ){
            if( (num&1) == 1 ){
                odds++ ; 
                a = b+1 ; 
            }else {
                b = a+1 ; 
            }
        }
        int rs = Math.max( odds , nums.length - odds);
        rs = Math.max( rs , Math.max(a,b)); 
        return rs ; 
    }
}