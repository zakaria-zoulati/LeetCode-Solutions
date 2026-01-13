class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] rs = new int[2] ; 
        boolean[] map = new boolean[nums.length] ; 
        int i = 0 ; 
        for( int num : nums ){
            if( map[num] ){
                rs[i++] = num ; 
            }else {
                map[num] = true ; 
            }
        }
        return rs ; 
    }
}