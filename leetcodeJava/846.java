package leetcodeJava;

class Solution {
    private void decrease(Map<Integer, Integer> map, Integer key) {
        var count = map.get(key);
        if (count != null) {
            if (count.intValue() == 1) {
                map.remove(key);
            } else {
                map.put(key, Integer.valueOf(count.intValue() - 1));
            }
        }
    }
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        var map = new TreeMap<Integer, Integer>();
        for (int card : hand) {
            var count = map.getOrDefault(Integer.valueOf(card), Integer.valueOf(0));
            map.put(Integer.valueOf(card), Integer.valueOf(count.intValue() + 1));
        }
        for (int i = 0; i < hand.length / groupSize; i++) {
            var last = -1;
            for (int j = 0; j < groupSize; j++) {
                if (last == -1) {
                    var key = map.firstKey();
                    last = key.intValue();
                    decrease(map, key);
                } else {
                    var count = map.get(Integer.valueOf(last + 1));
                    if (count == null) {
                        return false;
                    }
                    last++;
                    decrease(map, Integer.valueOf(last));
                }
            }
        }
        return true;
    }
}
