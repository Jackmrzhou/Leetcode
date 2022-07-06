package leetcodeJava;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (var i = 0; i < gas.length; i++) {
            var cur = 0;
            for (var j = i; j < i+gas.length + 1; j++) {
                if (j == i+gas.length) return i;
                var _j = j % gas.length;
                cur += gas[_j];
                if (cur < cost[_j]) {
                    if (_j < i) return -1;
                    else i = _j;
                    break;
                }
                cur -= cost[_j];
            }
        }
        return -1;
    }
}
