class Solution {
    public int xorOperation(int n, int start) {
        int rs = start ; 
        for(int i=1 ; i<n ; i++){
            rs = rs ^ ( start + 2*i ); 
        }
        return rs ; 
    }
}