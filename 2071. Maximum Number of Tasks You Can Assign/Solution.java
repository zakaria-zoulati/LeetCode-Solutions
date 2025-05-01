class Solution {
    int n, m;
    int[] tasks;
    int[] workers;
    public boolean check(int tar, int pills, int strength) {
        int[] dq = new int[tar] ; 
        int in = tar-1 ; 
        int start = tar-1 ; 
        int ptr = m-1 ; 
        for( int i=tar-1 ; i>=0 ; --i ){
            while( ptr >= m-tar && workers[ptr] + strength >= tasks[i] ){
                dq[in--] = workers[ptr] ; 
                ptr-- ; 
            }
            if( start == in ){
                return false ; 
            }else if( dq[start] >= tasks[i] ){
                start-- ; 
            }else {
                if( pills == 0 ){
                    return false ; 
                }
                --pills ; 
                in++ ; 
            }
        }
        return true ; 
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        n = tasks.length;
        m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        int l = 0;
        int r = Math.min(n, m);
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(mid, pills, strength)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
