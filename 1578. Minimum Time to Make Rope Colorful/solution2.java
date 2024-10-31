class Solution {
    public int minCost(String ch, int[] t) {
        int n = ch.length(); 
        int sum = 0 ; 
        int max = 0 ;
        char prev = ch.charAt(0) ; 
        int curr = 0 ; 
        int i=0 ; 
        for( char c : ch.toCharArray() ){
            sum += t[i] ; 
            if( c == prev  ){
                if( t[i] > curr ){
                    curr = t[i] ; 
                }
            }else{
                prev = c ; 
                sum -= curr ; 
                curr = t[i] ; 
            }
            ++i ; 
        }
        return sum - curr ; 
    }
}