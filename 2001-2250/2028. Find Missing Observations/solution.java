class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length ; 
        int sum = 0 ;
        for(int num : rolls ){
            sum += num ; 
        }
        int missed = (( n+m )*mean ) - sum ; 
        if( missed > n*6 || missed < n ){
            return new int[0] ; 
        }
        int[] rs = new int[n] ; 
        int shared = missed/n ; 
        for(int i=0 ; i<n ; ++i){
            rs[i] = shared ; 
        }
        int remain = missed%n ; 
        for(int i=0; i<remain; ++i){
            rs[i]++ ; 
        }
        return rs ;
    }
}