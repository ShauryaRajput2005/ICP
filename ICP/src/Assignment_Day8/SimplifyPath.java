package Assignment_Day8;
import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] tests = {
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/"
        };
        for (String path : tests) {
            System.out.println(simplifyPath(path));
        }
    }
}
