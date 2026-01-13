class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size() ; 
        int prev = 0 ; 
        int rs = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            int curr = 1 ; 
            while( i+1<n && nums.get(i+1) > nums.get(i) ){
                i++ ; 
                curr++ ;  
            }
            rs = Math.max( rs , Math.min( curr , prev ) ) ; 
            rs = Math.max( rs , curr/2 ) ; 
            prev = curr ; 
        }
        return rs ; 
    }
}