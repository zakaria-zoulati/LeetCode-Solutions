class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length ; 
        boolean[] isUsed = new boolean[n] ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            boolean flag = true ; 
            for( int j=0 ; j<n ; ++j ){
                 if( isUsed[j] ) continue ; 
                 if( baskets[j] >= fruits[i] ){
                     isUsed[j] = true ; 
                     flag = false ; 
                     break ; 
                 }
            }
            if( flag ) rs++ ; 
        }
        return rs ;
    }
}