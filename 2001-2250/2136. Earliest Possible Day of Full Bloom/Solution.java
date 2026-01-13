class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length ; 
        int rs = 0 ; 
        int[][] map = new int[n][2] ; 
        for( int i=0 ; i<n ; ++i ){
            map[i][0] = growTime[i] ; 
            map[i][1] = plantTime[i] ; 
        }
        Arrays.sort( map , (a,b) -> b[0] - a[0] ) ; 
        int curr = 0 ; 
        int max = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            curr += map[i][1] ; 
            max = Math.max( max , curr + map[i][0] ) ; 
        }
        return Math.max( max , curr ) ; 
    }
}