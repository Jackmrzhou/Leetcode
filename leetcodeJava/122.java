package leetcodeJava;

class Solution {
    public int maxProfit(int[] prices) {
        var res = 0;
        for (var i = 0; i < prices.length; i++) {
            var low = i;
            for (var j = i+1; j < prices.length; j++) {
                if (prices[j] < prices[j-1]) {
                    low = j;
                } else {
                    break;
                }
            }
            var high = -1;
            for (var j = low+1; j < prices.length; j++) {
                if (prices[j] > prices[j-1]) high = j;
                else break;
            }
            if (high != -1) {
                res += prices[high] - prices[low];
                i = high;
            }
        }
        return res;
    }
}
