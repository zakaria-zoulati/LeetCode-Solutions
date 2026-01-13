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
        int[] compute = new int[n] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            if( nums[i] <= nums[i+1] ){
                compute[i] = compute[i+1] + 1 ; 
            }
        }
        int u = 0 ; 
        for( int i=1 ; i+time<n ; ++i ){
            if( nums[i] <= nums[i-1] ){
                u++ ; 
                if( u>=time && compute[i] >=time ){
                    rs.add( i ) ; 
                }
            }else{
                u = 0 ; 
            }
        }
        return rs ;   
    }
}