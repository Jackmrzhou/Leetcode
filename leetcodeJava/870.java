package leetcodeJava;

class Solution {
    private void decr(TreeMap<Integer, Integer> map, Integer k) {
        var val = map.get(k);
        if (val.intValue() == 1) map.remove(k);
        else map.put(k, Integer.valueOf(val.intValue() - 1));
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        var map = new TreeMap<Integer, Integer>();
        for (var n : nums1) {
            var count = map.getOrDefault(Integer.valueOf(n), Integer.valueOf(0));
            map.put(Integer.valueOf(n), Integer.valueOf(count.intValue() + 1));
        }
        var res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            var k = map.ceilingKey(Integer.valueOf(nums2[i]+1));
            if (k == null) {
                var key = map.firstKey();
                decr(map, key);
                res[i] = key.intValue();
            } else {
                res[i] = k.intValue();
                decr(map, k);
            }
        }
        return res;
    }
}
