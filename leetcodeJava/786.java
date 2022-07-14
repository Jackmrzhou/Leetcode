package leetcodeJava;

class Solution {
    class fraction {
        int i, j;
        public fraction(int i, int j) {
            this.i = i;
            this.j = j;
        }
        private fraction next() {
            if (i < j-1) {
                return new fraction(i+1, j);
            }
            return null;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        var pq = new PriorityQueue<fraction>(arr.length, (a, b) -> {
            double x = arr[a.i];
            x /= arr[a.j];
            double y = arr[b.i];
            y /= arr[b.j];
            if (x < y) return -1;
            else if (x > y) return 1;
            return 0;
        });
        for (int i = 1; i < arr.length; i++) {
            pq.add(new fraction(0, i));
        }
        fraction f = null;
        while (k-- > 0) {
            f = pq.remove();
            var n = f.next();
            if (n != null) {
                pq.add(n);
            }
        }
        return new int[]{arr[f.i], arr[f.j]};
    }
}
