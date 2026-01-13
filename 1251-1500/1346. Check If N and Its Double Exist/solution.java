class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] f = new boolean[2001] ; 
        for(int i : arr){
            if( i % 2 == 0 && f[i/2 + 1000] ){
                return true ; 
            }else if( 2*Math.abs(i) <= 1000 && f[2*i+1000] ){
                return true ; 
            }
            f[i+1000] = true ; 
        }
        return false  ; 
    }
}