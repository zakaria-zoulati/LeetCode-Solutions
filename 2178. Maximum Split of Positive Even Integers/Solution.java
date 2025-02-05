class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        // long count = finalSum / 6 + (finalSum % 6 == 5 ? 1 : 0);
        List<Long> rs = new ArrayList<>(); 
        long curr = 2;
        while (finalSum > (curr << 1)) {
            rs.add(curr);
            finalSum -= curr;
            curr += 2;
        }
        rs.add(finalSum);
        return rs;
    }
}