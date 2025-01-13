class Solution {
    public int minimumLength(String s) {
        int[] f = new int[128] ; 
        for(char c : s.toCharArray()){
            ++f[c] ; 
        }
        int rs = 0 ; 
        for(int i:f){
            if(i==0)continue ; 
            rs += (i+1)%2 + 1 ; 
        }
        return rs  ;
    }
}