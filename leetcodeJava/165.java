package leetcodeJava;

class Solution {
    public int compareVersion(String version1, String version2) {
        var v1 = version1.split("\\.");
        var v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            var n = 0;
            if (i < v1.length)
                n = Integer.valueOf(v1[i]).intValue();
            var m = 0;
            if (j < v2.length)
                m = Integer.valueOf(v2[j]).intValue();
            if (n > m) return 1;
            else if (n < m) return -1;
            i++;
            j++;
        }
        return 0;
    }
}
