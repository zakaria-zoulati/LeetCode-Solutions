class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n  = spells.length ; 
        int m = potions.length ; 
        int[] ans = new int[n] ;
        Arrays.sort( potions ) ; 
        for( int i=0 ; i<n ; ++i ){
            long curr = spells[i] ; 
            if( curr*potions[m-1] >= success ){
                int l = 0 ; 
                int r = m-1 ; 
                while( l < r ){
                    int mid = l + ( r - l )/2 ; 
                    if( curr*potions[mid] >= success ){
                        r = mid ; 
                    }else {
                        l = mid + 1; 
                    }
                }
                ans[i] = m - l ; 
            }
        }
        return ans; 
    }
}