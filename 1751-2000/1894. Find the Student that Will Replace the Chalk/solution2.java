class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length ; 
        long total = 0 ; 
        for( int num : chalk){
            total += num ; 
        }
        int inter = (int) (k % total)  ; 
        for(int i=0 ; i<n ; ++i){
            if( chalk[i] > inter  ) {
                return i ; 
            }
            inter -= chalk[i] ; 
        }
        return 0; 
    }
}