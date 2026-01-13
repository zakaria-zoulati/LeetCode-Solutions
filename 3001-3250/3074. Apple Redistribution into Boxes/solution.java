class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length ; 
        int m = capacity.length ; 
        int all = 0 ;
        for(int i=0 ; i<n ; ++i ){
            all += apple[i] ; 
        }
        Arrays.sort(capacity) ; 
        for(int i=m-2 ; i>=0 ; --i){
            capacity[i] += capacity[i+1] ; 
        }
        Arrays.sort(capacity) ; 
        int left = 0 ; 
        int right = m-1 ; 
        while( left < right ){
            int middle = left + (right-left)/2 ; 
            if( capacity[middle] < all ){
                left = middle +1  ;
            }else {
                right = middle ; 
            }
        }
        return left + 1 ; 
    }
}