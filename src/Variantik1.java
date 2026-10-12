import java.util.ArrayDeque;

public class Variantik1 {

    public static boolean stackResult(String str) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char atNow = str.charAt(i);

            if (atNow == '(' || atNow == '{' || atNow == '[') {
                stack.push(atNow);

            } else if (stack.isEmpty()) {
                return false;

            } else if ((stack.peek() == '(' && atNow == ')') ||
                    (stack.peek() == '{' && atNow == '}') ||
                    (stack.peek() == '[' && atNow == ']')) {
                stack.pop();

            } else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }

}
