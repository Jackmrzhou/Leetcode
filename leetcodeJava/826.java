package leetcodeJava;

class Solution {

    class Job {
        int d, p;
        public Job(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        var preMax = new int[profit.length];
        var jobs = new Job[profit.length];
        for (int i = 0; i < profit.length; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (x, y) -> x.d - y.d);
        var max = 0;
        for (int i = 0; i < profit.length; i++) {
            if (jobs[i].p > max) {
                max = jobs[i].p;
            }
            preMax[i] = max;
        }
        var res = 0;
        for (int i = 0; i < worker.length; i++) {
            var index = maxLess(jobs, worker[i]);
            if (index != -1) {
                res += preMax[index];
            }
        }
        return res;
    }
    
    private int maxLess(Job[] jobs, int target) {
        if (jobs[0].d > target) return -1;
        int l = 0, r = jobs.length - 1;
        while( l < r ) {
            int mid = (r-l)/2 + l;
            if (jobs[mid].d > target) r = mid;
            else l = mid+1;
        }
        if (jobs[l].d > target) return l-1;
        return l;
    }
}
