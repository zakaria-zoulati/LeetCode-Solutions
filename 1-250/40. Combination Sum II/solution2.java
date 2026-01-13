class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        sumHelper(0, res, candidates, target, new ArrayList<>());
        return res;
    }
    void sumHelper(int index, List<List<Integer>> res, int[] candidates, int target, List<Integer> ds) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            ds.add(candidates[i]);
            sumHelper(i + 1, res, candidates, target - candidates[i], ds);
            ds.remove(ds.size() - 1);
        }
    }
}