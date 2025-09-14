class Solution {
    public int earliestTime(int[][] tasks) {
        int rs = Integer.MAX_VALUE ; 
        for( int[] t : tasks ){
            rs = Math.min( rs , t[0] + t[1] ) ; 
        }
        return rs ; 
    }
}