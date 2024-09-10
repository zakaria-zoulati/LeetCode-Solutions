class Solution {
    public long coloredCells(int n) {
        long val = n ; 
        long rs = 1 + 2*val*(val-1) ; 
        return rs ;
    }
}