package leetcodeJava;

class Solution {
    public double myPow(double x, int nn) {
        // n to bits
        long n = nn;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        if (n == 0) {
            return 1;
        }
        double res = 1, tmp = x;
        while (n != 0) {
            if (n%2 == 1) {
                res = res * tmp;
            } 
            n = n/2;
            tmp = tmp * tmp;
        }
        return res;
    }
}