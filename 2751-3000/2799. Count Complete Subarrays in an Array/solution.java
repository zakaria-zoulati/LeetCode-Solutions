class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length ; 
        int len = 0 ; 
        HashSet<Integer> set = new HashSet<>() ; 
        for(int num : nums){
            set.add( num ) ; 
        }        
        len = set.size() ; 
        if( len == 1 ){
            return n*(n+1)/2 ; 
        }
        int rs = 0 ; 
        g:for(int i=0 ; i+len-1<n ; ++i){
            HashSet<Integer> helper = new HashSet<>() ; 
            for(int j=i ; j<n ; ++j ){
                helper.add( nums[j] ) ; 
                if( helper.size() == len ){
                    rs += n - j ; 
                    continue g ; 
                }
            }
        }
        return rs  ; 
    }
}