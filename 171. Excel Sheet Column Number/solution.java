class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length() ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            rs += ( columnTitle.charAt(i) - 'A' + 1)*Math.pow(26, n-1 -i ) ; 
        }
        return rs ; 
    }
}