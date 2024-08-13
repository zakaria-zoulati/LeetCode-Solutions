class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] a = new int[n+1] ;
        int[] b = new int[n+1] ;  
        int len = trust.length ; 
        for(int i= 0 ; i<len ;++i){
            a[ trust[i][0] ]++ ;
            b[ trust[i][1] ]++ ;
        }
        for(int i=1 ; i<=n ; ++i){
            if( a[i] == 0 && b[i] == n-1 ) return i ; 
        }
        return -1 ;
    }
}