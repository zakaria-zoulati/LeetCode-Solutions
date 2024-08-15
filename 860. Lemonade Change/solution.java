class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length ; 
        int ci = 0 ; 
        int di = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            if( bills[i] == 5  ){
                ci++ ;
            }else if( bills[i] == 10 ){
                if( ci >0 ){
                    di++; 
                    ci-- ; 
                }else {
                    return false ;
                }
            }else {
                if( ci*5+di*10 >=15 && ci != 0 ){
                    if( di >0 ){
                        ci-- ; 
                        di--; 
                    }else {
                        ci = ci-3 ; 
                    }
                }else {
                    return false ; 
                }
            }
        }
        return true ; 
    }
}