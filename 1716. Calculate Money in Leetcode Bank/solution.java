class Solution {
    public int totalMoney(int n) {
        int rs = 0 ; 
        int s = n/7 ; 
        rs += 28*s ; 
        rs += 7*s*(s-1)/2 ; 
        int inter = n%7 ; 
        rs += inter*(inter+1)/2 ; 
        rs += s*(inter) ; 
        return rs ; 
    }
   
}