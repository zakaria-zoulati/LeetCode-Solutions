class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length ; 
        List<Integer> rs = new ArrayList<>() ; 
        boolean[] map = new boolean[n+1] ; 
        for( int num : nums ){
            if( map[num] ){
                rs.add( num ) ; 
            }else {
                map[num] = true ; 
            }
        }
        return rs ; 
    }
}