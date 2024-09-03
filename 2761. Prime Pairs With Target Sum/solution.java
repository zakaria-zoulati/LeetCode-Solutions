class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i*i <= n; ++i) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <= n / 2; ++i) {
            if (!isPrime[i] && !isPrime[n - i]) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(n - i);
                list.add(pair);
            }
        }

        return list;
    }
}
