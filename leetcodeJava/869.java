package leetcodeJava;

class Solution {
    private String sort(String s) {
        var arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
    public boolean reorderedPowerOf2(int n) {
        var set = new HashSet<String>();
        for (int i = 0; i < 31; i++) {
            set.add(sort(String.valueOf(1<<i)));
        }
        if (set.contains(sort(String.valueOf(n)))) return true;
        return false;
    }
}
