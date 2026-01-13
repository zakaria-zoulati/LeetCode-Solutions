class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length ; 
        int[] expected = heights.clone() ; 
        Arrays.sort( expected ) ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( heights[i] != expected[i] ){
                rs++ ;
            }
        }
        return rs ; 
    }
}