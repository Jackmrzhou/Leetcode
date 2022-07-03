package leetcodeJava;

class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) return Arrays.stream(new int[]{0, 1}).boxed().collect(Collectors.toList());
        var g = grayCode(n-1);
        var li = g.listIterator(g.size());
        var newList = new LinkedList();
        while (li.hasPrevious()) {
            newList.add((1<<(n-1)) + li.previous());
        }
        g.addAll(newList);
        return g;
    }
}
