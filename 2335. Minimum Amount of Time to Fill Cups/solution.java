class Solution {
    public int fillCups(int[] amount) {
        int rs = 0 ; 
        Arrays.sort( amount ) ; 
        if( amount[2] >= amount[1] + amount[0] ){
            return amount[2] ; 
        }
        int c = amount[1] + amount[0] - amount[2] ;  
        rs += c%2 == 0 ? c/2 : ( c/2 ) + 1 ; 
        rs += amount[2] ; 
        return rs ;        
    }
}