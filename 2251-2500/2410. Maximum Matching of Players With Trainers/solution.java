class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length ; 
        int m = trainers.length ; 
        Arrays.sort( players ) ; 
        Arrays.sort( trainers ) ; 
        int curr = 0 ; 
        int rs = 0 ; 
        for(int i=0 ; i<m && curr<n ; ++i){
            if( trainers[i] >= players[curr] ){
                rs++ ; 
                curr++ ; 
            }
        }
        return rs ; 
    }
}