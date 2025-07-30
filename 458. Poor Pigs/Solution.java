class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if( buckets == 1  ){
            return 0 ; 
        }
        int rounds = minutesToTest / minutesToDie;
        int pigs = 0;
        while (Math.pow(rounds + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
