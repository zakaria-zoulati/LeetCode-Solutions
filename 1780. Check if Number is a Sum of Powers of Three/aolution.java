class Solution {
    public boolean checkPowersOfThree(int n) {
        if( n <= 1) return true ; 
        if( n%3 == 0 ){
            return checkPowersOfThree( n/3 ) ; 
        }
        else if( n%3 == 2 ) return false ; 
        else {
            return checkPowersOfThree( n - n%3 ) ; 
        }
    }
}