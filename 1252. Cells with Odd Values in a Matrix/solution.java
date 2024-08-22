class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int inter = indices.length ; 
        int rs = 0 ; 
        int[] lines = new int[m] ; 
        int[] cols = new int[n] ; 
        for(int i=0 ; i<inter ; ++i){
            lines[ indices[i][0] ]++ ; 
        }
        for(int i=0 ; i<inter ; ++i){
            cols[ indices[i][1] ]++ ; 
        }
        int a = 0 ; // even
        int b = 0 ; 
        int c= 0 ; // even
        int d = 0 ;
        for(int i=0 ; i<m ; ++i){
            if(  lines[i] % 2 == 0 ) a++ ; 
            else b++ ;
        }
        for(int i=0 ; i<n ; ++i){
            if(  cols[i] % 2 == 0 ) c++ ; 
            else d++ ;
        }
        rs = a*d + b*c ; 
        return rs ;

    }
}