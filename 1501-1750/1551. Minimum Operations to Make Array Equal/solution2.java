class Solution {
    public int minOperations(int n) {
        int mid = n / 2;
        if( n%2 == 1  ){
            return 2*(  mid*mid - ( mid -1 )*mid/2 )  ;
        }

        return mid + mid*(mid-1) ; 

    }
}