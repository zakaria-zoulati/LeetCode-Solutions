class Solution {
    public int alternateDigitSum(int n) {
        String inter = String.valueOf(n) ; 
        int len = inter.length() ; 
        int rs =0 ; 
        boolean flag = true ; 
        for(int i=0 ; i<len; ++i){
            int a = inter.charAt(i) - '0' ; 
            if( flag  ){
                rs += a ; 
            }else {
                rs -= a ;
            }
            flag = !flag ; 
        }
        return rs ; 
    }
}