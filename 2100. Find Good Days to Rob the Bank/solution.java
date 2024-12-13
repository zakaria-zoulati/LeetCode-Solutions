class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length ; 
        List<Integer> rs = new ArrayList<>() ; 
        if( time == 0 ){
            for( int i=0 ; i<n ; ++i ){
                rs.add(i) ; 
            }
            return rs ; 
        }
        int[][] compute = new int[n][2] ; 
        for( int i=1 ; i<n ; ++i ){
            if( nums[i] == nums[i-1] ){
                compute[i][1] = compute[i-1][1] + 1 ; 
                compute[i][0] = compute[i-1][0] + 1 ; 
            }else if( nums[i] < nums[i-1] ){
                compute[i][0] = compute[i-1][0] + 1; 
            }else {
                compute[i][1] = compute[i-1][1] + 1; 
            }
        }
        for( int i=time ; i+time<n ; ++i ){
            if( compute[i][0] >= time && compute[i+time][1] >= time ){
                rs.add( i ) ; 
            }
        }
        return rs ;   
    }
}