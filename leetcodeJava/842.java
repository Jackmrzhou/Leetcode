package leetcodeJava;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        if (num.length() < 3) return new LinkedList();
        long a = 0, b = 0;
        long max = (1l << 31);
        var res = new LinkedList<Integer>();
        for (int i = 1; i < Math.min(11, num.length()); i++)
            for (int j = i+1; j < Math.min(i+11, num.length()); j++) {
                res = new LinkedList<Integer>();
                a = Long.valueOf(num.substring(0, i)).longValue();
                b = Long.valueOf(num.substring(i, j)).longValue();
                if (a >= max || b >= max) break;
                if ( a > 0 && num.charAt(0) == '0' || b > 0 && num.charAt(i) == '0') break;
                var subStr = num.substring(j, num.length());
                var found = true;
                res.add(Integer.valueOf((int)a));
                res.add(Integer.valueOf((int)b));
                while (subStr != null && subStr.length() != 0) {
                    long tmp = a+b;
                    if (tmp >= max) {
                        found = false;
                        break;
                    }
                    var str = String.valueOf(tmp);
                    if (subStr.startsWith(str)) {
                        res.add(Integer.valueOf((int)tmp));
                        subStr = subStr.substring(str.length(), subStr.length());
                    } else {
                        found = false;
                        break;
                    }
                    a = b;
                    b = tmp;
                }
                if (found && res.size() > 2) return res;
            }
        return new LinkedList<Integer>();
    }
}
