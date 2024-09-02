class Solution {
    public int numberOfChild(int n, int k) {
        int curr = 0 ; 
        boolean flag = true ; 
        while( k-- >0  ){
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
        return curr ; 
    }
}