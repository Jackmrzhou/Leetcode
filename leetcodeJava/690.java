package leetcodeJava;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for (var e : employees) {
            map.put(Integer.valueOf(e.id), e);
        }
        var memo = new int[2001];
        Arrays.fill(memo, -1);
        return solve(memo, map, id);
    }
    
    private int solve(int[] memo, Map<Integer, Employee> map, int id) {
        if (memo[id] != -1) return memo[id];
        var employee = map.get(Integer.valueOf(id));
        var res = employee.importance;
        for (var e : employee.subordinates){
            res += solve(memo, map, e);
        }
        memo[id] = res;
        return res;
    }
}
