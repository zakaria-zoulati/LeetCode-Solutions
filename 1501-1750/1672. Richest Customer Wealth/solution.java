class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length ; 
        int m = accounts[0].length ; 
        int curr = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            int inter = 0 ; 
            for(int j=0 ; j<m ; ++j){
                inter += accounts[i][j] ; 
            }
            if( inter > curr ){
                curr = inter ; 
            }
        }
        return curr ; 
    }
}