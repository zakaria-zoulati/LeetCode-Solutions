class Solution {
    public int passThePillow(int n, int time) {
         int curr = 0 ; 
        boolean flag = true ; 
        while( time-- >0  ){
            if(flag ){
                if( curr == n-1 ){
                    curr-- ; 
                    flag = false ;
                }else {
                    curr++ ;
                }
            }else {
                if( curr == 0 ){
                    curr++ ; 
                    flag = true ; 
                }else {
                    curr-- ;
                }
            }
        } 
        return curr+1 ; 
    }
}