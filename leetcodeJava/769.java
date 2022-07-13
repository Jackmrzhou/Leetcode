package leetcodeJava;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        var res = 1;
        for (int i = 1; i < arr.length; i++) {
            var x = Arrays.copyOfRange(arr, 0, i);
            var y = Arrays.copyOfRange(arr, i, arr.length);
            var max = Arrays.stream(x).max().getAsInt();
            var min = Arrays.stream(y).min().getAsInt();
            if (min > max) res = Math.max(res, maxChunksToSorted(x) + maxChunksToSorted(y));
        }
        return res;
    }
}
