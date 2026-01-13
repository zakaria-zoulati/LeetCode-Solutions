class Solution {
    public int[] constructRectangle(int area) {
        int[] rs = new int[2] ; 
        int inter = (int) Math.sqrt(area) ; 
        if( inter * inter != area ){
            inter++ ; 
        }
        for(int i=inter ; i<=area ; i++){
            if( area % i == 0  ){
                rs[0] = i ; 
                rs[1] = area/i ;
                break ; 
            }
        }
        return rs ; 
    }
}