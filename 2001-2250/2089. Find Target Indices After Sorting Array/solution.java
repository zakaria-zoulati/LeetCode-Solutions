class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length ;
        List<Integer> list = new ArrayList<>() ; 
        int rs = 0 ; 
        int less = 0 ; 
        for(int i=0 ; i<n ;++i){
            if( nums[i] < target ) less++ ;
            if(  nums[i] == target  ) rs++ ;
        }
        for(int i=0 ; i<rs ; ++i){
            list.add( less+i );
        }
        return list ; 

    }
}