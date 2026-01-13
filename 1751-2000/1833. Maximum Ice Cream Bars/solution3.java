class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int rs = 0;  
        int[] items = new int[100001] ; 
        for(int num : costs){
            items[num]++  ; 
        }
        for(int i=1 ; i<= Math.min( 100000 , coins ) ; ++i){
            int amount = Math.min( items[i] , coins/i ); 
            rs += amount ; 
            coins -= amount*i ; 
        }
        return rs ; 
    }
}