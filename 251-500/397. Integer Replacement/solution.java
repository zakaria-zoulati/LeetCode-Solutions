class Solution {
    public int integerReplacement(long n) {
        int rs = 0;
        for (; n > 1; ++rs)
            if ((n & 1) == 0)    n >>= 1;
            else if  (n==3 ||  ((n >> 1) & 1) == 0 )    --n;
            else    ++n;
        return rs;
    }
}