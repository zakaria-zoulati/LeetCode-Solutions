class Solution {
    public int subtractProductAndSum(int n) {
        int rs = 0 ; 
        int p = 1 ; 
        int sum = 0 ; 
        String inter = String.valueOf(n) ; 
        int len =  inter.length() ; 
        for(int i=0 ; i<len ; ++i){
            p *= ( inter.charAt(i) - '0' ) ; 
            sum += ( inter.charAt(i) - '0' ) ; 
        }

        rs = p - sum ; 
        return rs ; 

    }
}