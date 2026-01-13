class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length ; 
        int poss1 = 0 ; 
        int poss2 = 1 ; 
        for(int i=0 ; i<n-1 ; ++i ){
            poss1 ^= derived[i] ; 
            poss2 ^= derived[i] ; 
        }

        if( (poss1^0) == derived[n-1]  || (poss2^1) == derived[n-1] ){
            return true ; 
        }

        return false ; 
    }
}