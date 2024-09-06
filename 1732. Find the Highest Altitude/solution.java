class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0 ;
        int rs = 0 ; 
        for(int num : gain){
            curr += num ; 
            if( curr > rs ){
                rs = curr ; 
            }
        }
        return rs ; 
    }
}