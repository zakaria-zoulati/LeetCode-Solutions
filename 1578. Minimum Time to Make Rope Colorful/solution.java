class Solution {
    public int minCost(String colors, int[] neededTime) {
        int rs = 0 ; 
        int n = colors.length() ; 
        for( int i=0 ; i<n ; ++i ){
            int sum = neededTime[i] ; 
            int max = neededTime[i] ; 
            while( i+1<n && colors.charAt( i+1 ) == colors.charAt(i) ){
                sum += neededTime[i+1] ; 
                max = Math.max( max , neededTime[i+1] ) ;
                ++i ; 
            }
            rs += sum - max ; 
        }
        return rs ; 
    }
}