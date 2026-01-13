class Solution {
    public long helper( long n ){
        if( n <= 2 ){
            return 1 ; 
        }
        long rem = n - n/2 ; 
        long inter = helper( rem ) ; 
        long pos = rem - inter + 1 ; 
        return 2*(pos-1) + 1 ; 
    }
    public long lastInteger(long n) {
        return helper(n) ; 
    }
}