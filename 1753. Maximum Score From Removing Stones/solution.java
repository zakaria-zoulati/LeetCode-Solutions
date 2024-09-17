class Solution {
    public int maximumScore(int a, int b, int c) {
        int score = 0 ; 
        int[] all = new int[]{a,b,c} ; 
        Arrays.sort( all ) ; 
        if( all[0] <= all[2] - all[1]  ){
            return all[0] + all[1] ; 
        }else {
            score += all[0] ; 
            int d = all[0] ; 
            d -= ( all[2] - all[1] ) ; 
            all[2] = all[1] ; 
            score += all[2] - (d%2 == 0 ? d/2 : d/2 + 1) ;
        }
        return score ; 
    }
}