package leetcodeJava;

class Solution {
    private int next(int[] arr, int i) {
        var stack = new LinkedList<Integer>();
        stack.add(Integer.valueOf(i));
        for (int j = i+1; j < arr.length; j++) {
            if (stack.isEmpty()) return j-1;
            if (arr[j] > 0) {
                stack.add(Integer.valueOf(j));
            } else if (arr[j] < 0) {
                if (-arr[j] < arr[stack.getLast().intValue()]) {
                    arr[j] = -101;
                } else if (-arr[j] == arr[stack.getLast().intValue()]) {
                    arr[j] = -101;
                    arr[stack.getLast().intValue()] = -101;
                    stack.removeLast();
                } else {
                    while (!stack.isEmpty()) {
                        var last = stack.getLast().intValue();
                        if (arr[last] == -arr[j]) {
                            arr[j] = -101;
                            arr[last] = -101;
                            stack.removeLast();
                            break;
                        } else if (arr[last] > -arr[j]) {
                            arr[j] = -101;
                            break;
                        } else {
                            arr[last] = -101;
                            stack.removeLast();
                        }
                    }
                    if (stack.isEmpty()) return j;
                }
            }
        }
        return arr.length;
    }
    
    public int[] asteroidCollision(int[] asteroids) {
        var arr = asteroids;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                i = next(arr, i);
            }
        }
        return Arrays.stream(arr).filter(x -> x != -101).toArray();
    }
}
