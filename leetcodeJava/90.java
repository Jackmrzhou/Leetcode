package leetcodeJava;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solve(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
    
    private List<List<Integer>> solve(List<Integer> nums) {
        if (nums.size() == 0) return List.of(new LinkedList<Integer>());
        var res = new LinkedList<List<Integer>>();
        var end = 0;
        for (end = 0; end < nums.size(); end++) {
            if (nums.get(end) != nums.get(0)) {
                break;
            }
        }
        var s = solve(nums.subList(end, nums.size()));
        for (var l : s) {
            res.add(l);
            var copy = new LinkedList<Integer>(l);
            for (var j = 0; j < end; j++){
                copy = new LinkedList<Integer>(copy);
                copy.add(0, nums.get(0));
                res.add(copy);
            }
        }
        return res;
    }
}
