package leetcodeJava;
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        var map = new HashMap<String, Integer>();
        for (var d: cpdomains) {
            var arr = d.split(" ");
            var count = Integer.valueOf(arr[0]);
            var ds = Arrays.asList(arr[1].split("\\."));
            for (int i = 0; i < ds.size(); i++) {
                var key = String.join(".", ds.subList(i, ds.size()));
                var value = map.getOrDefault(key, Integer.valueOf(0));
                map.put(key, Integer.valueOf(value.intValue() + count.intValue()));
            }
        }
        return map.entrySet().stream().map(x -> String.valueOf(x.getValue()) + " " + String.valueOf(x.getKey())).collect(Collectors.toList());
    }
}
