package leetcodeJava;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return solve(Arrays.stream(nums).boxed().toList());
    }
    
    private List<List<Integer>> solve(List<Integer> nums) {
        if (nums.size() == 0) return List.of(new LinkedList<Integer>());
        var res = new LinkedList<List<Integer>>();
        var s = solve(nums.subList(1, nums.size()));
        for (var l : s) {
            res.add(l);
            var copy = new LinkedList<Integer>(l);
            copy.add(0, nums.get(0));
            res.add(copy);
        }
        return res;
    }
}
