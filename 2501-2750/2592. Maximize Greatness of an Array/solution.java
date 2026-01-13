class Solution {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length ; 
        Arrays.sort( nums ) ; 
        int rs = 0 ; 
        int low = 0 ; 
        int on = 0 ; 
        for( int i=0 ; i<n ; i++ ){
            ++on; 
            while( i+1<n && nums[i+1] == nums[i] ){
                on++ ; 
                i++ ;
            }
            rs += low>on ? on : low ; 
            low += on - (low>on ? on : low) ; 
            on = 0; 
        }
        return rs ; 
    }
}