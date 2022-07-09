package leetcodeJava;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        var isNeg = false;
        if (n < 0 && d > 0 || n > 0 && d < 0) {
            isNeg = true;
            n = Math.abs(n);
            d = Math.abs(d);
        }
        long x = 0;
        x = n/d;
        n = n - n/d * d;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (isNeg) sb.insert(0, '-');
        if (n != 0) {
            sb.append(".");
        }
        Map<Long, Integer> indexMap = new HashMap();
        var index = sb.length();
        while (n != 0) {
            n = n*10;
            var i = indexMap.get(Long.valueOf(n));
            if (i != null) {
                sb.insert(i.intValue(), '(');
                sb.append(')');
                break;
            } else {
                indexMap.put(Long.valueOf(n), Integer.valueOf(index));
                index++;
                var y = n/d;
                sb.append(String.valueOf(y));
                n -= y*d;
            }
        }
        return sb.toString();
    }
}
