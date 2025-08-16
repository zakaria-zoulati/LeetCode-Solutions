class Solution {
    public int minSensors(int n, int m, int k) {
        k = 1 + 2*k; 
        int a = ( m + k - 1  )/(k) ; 
        int b = ( n + k -1 )/(k); 
        int rs = a*b ; 
        return rs ; 
    }
}