class Solution {
    public long countBadPairs(int[] nums) {
        long rs = 0 ;
        int n = nums.length ; 
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        for(int i=0 ; i<n ; ++i){
            int inter = i - nums[i] ; 
            int count = map.getOrDefault(inter ,0 ) ;
            rs +=  i - count  ; 
            map.put( inter , count + 1 ) ; 
        }
        return rs ; 

    }
}