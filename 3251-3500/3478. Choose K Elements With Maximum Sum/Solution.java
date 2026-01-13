import java.util.* ; 
public class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length; 
        long[] rs = new long[n]; 
        
        long[][] values = new long[n][2]; 
        for (int i = 0; i < n; ++i) {
            values[i] = new long[]{ nums1[i], i }; 
        }
        Arrays.sort(values, 
            (a, b) -> Long.compare(a[0], b[0])        
        ); 
        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a, b)   
        ); 
        long pref = 0L; 
        long prev = 0L; 
        List<Long> cache = new ArrayList<>(); 
        long rem = 0L; 
        for (int i = 0; i < n; ++i) {
            int idx = (int) values[i][1]; 
            while (pq.size() > k) {
                prev -= pq.poll(); 
            }
            rs[idx] = prev; 
            rem += (long) nums2[idx]; 
            cache.add((long) nums2[idx]); 
            while (i + 1 < n && values[i + 1][0] == values[i][0]) {
                rs[(int) values[i + 1][1]] = prev; 
                cache.add((long) nums2[(int) values[i + 1][1]]); 
                rem += nums2[(int) values[i + 1][1]]; 
                i++; 
            }
            pq.addAll(cache); 
            prev += rem; 
            rem = 0; 
            cache.clear(); 
        }
        return rs; 
    }
}
