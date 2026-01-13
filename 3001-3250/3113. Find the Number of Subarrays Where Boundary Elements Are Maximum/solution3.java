import java.util.*  ;
class Solution {
    public long numberOfSubarrays(int[] nums) {
        Deque<int[]> s = new ArrayDeque<>();
        long res = 0;
        for (int c : nums) {
            while (s.size() > 0 && s.peek()[0] < c)
                s.pop();
            if (s.size() == 0 || s.peek()[0] > c)
                s.push(new int[]{c, 0});
            res += ++s.peek()[1];
        }
        return res;
    }
}
