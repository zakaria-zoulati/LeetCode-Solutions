class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length ;
        Arrays.sort(nums) ;  
        int len = 0 ; 
        int start = 0 ; 
        int second = 0 ; 
        boolean flag = true ;
        for(int i=0 ; i<n ; i++){
            flag = false ; 
            start = i ;
            while( i+1<n && nums[i]==nums[i+1] ){
                i++; 
            }
            second = i ; 
            while( i+1<n && nums[i+1] == nums[start]+1 ){
                i++; 
                flag = true ; 
            }
            if( flag){
                len = Math.max(len, i-start+1 ) ; 
            }
            i = second ; 
        }

        return len ; 

    }
}