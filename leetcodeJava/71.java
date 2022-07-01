package leetcodeJava;

class Solution {
    public String simplifyPath(String path) {
        var dirs = path.split("/");
        var stack = new Stack<String>();
        for (var dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (!dir.equals(".") && !dir.equals("")) {
                stack.push(dir);
            }
        }
        var sb = new StringBuilder();
        while(!stack.empty()) {
            sb.insert(0, "/" + stack.pop());
        }
        var res = sb.toString();
        if (res.length() == 0) return "/";
        return res;
    }
}
