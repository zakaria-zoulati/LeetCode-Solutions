class Solution {
    public int minCost(String c, int[] t) {
        int rs = 0; 
        int n = c.length(); 
        char[] chars = c.toCharArray(); 
        for( int i=0 ; i<n ; ++i ){
            int sum =t[i] ; 
            int max =sum ; 
            while( i+1<n && chars[i+1]==chars[i]){
                sum += t[i+1]; 
                ++i ; 
                if(t[i] > max){
                    max = t[i];
                }
            }
            rs +=sum-max; 
        }
        return rs; 
    }
}