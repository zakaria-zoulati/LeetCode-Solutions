class Solution {
    public int smallestNumber(int n) {
        while( ( (n+1) & n ) != 0 ) n++ ; 
        return n ; 
    }
}