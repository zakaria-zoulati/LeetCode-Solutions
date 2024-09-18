class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length ; 
        Arrays.sort( satisfaction ) ; 
        int rs = 0; 
        if( satisfaction[n-1] <= 0 ) return 0 ;
        int curr = satisfaction[n-1] ; 
        rs = satisfaction[n-1] ; 
        for( int i=n-2 ; i>=0 ; --i ){
            if( satisfaction[i] + curr >= 0 ){
                rs += curr + satisfaction[i] ; 
                curr += satisfaction[i] ; 
            }else break ; 
        }
        return rs ; 
    }
}