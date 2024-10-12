class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length ; 
        List<Integer> rs = new ArrayList<>() ; 
        int[] map = new int[n+1] ; 
        for( int num : nums ){
           map[num]++ ; 
        }
        for(int i=1 ; i<=n ; ++i){
            if( map[i] > 1 ) rs.add(i) ; 
        }
        return rs ; 
    }
}