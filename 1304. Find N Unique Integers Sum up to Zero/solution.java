class Solution {
    public int[] sumZero(int n) {
        int[] rs = new int[n] ; 
        int curr = 0 ; 
        if( n%2 == 1 ){
            rs[curr++] = 0 ; 
        }
        int ele = 1 ; 
        for(int i=0 ; i<n/2 ; ++i){
            rs[curr++] = ele ; 
            rs[curr++] = -ele ; 
            ele++ ;
        }

        return rs ; 
    }
}