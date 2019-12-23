package HW3;

import java.util.Stack;

public class StringMirror {
    public static void main(String[] args) {
        String string = "qwerty";
        String strMirror = Stringmirror(string);
        System.out.println(strMirror);
    }

    public static String Stringmirror(String str) {
        String result;
        Stack<Character> stack = new Stack<>();
        char[] charStr = str.toCharArray();

        for (int i = 0; i < charStr.length; i++) {
            stack.push(charStr[i]);
        }

        for (int i = 0; i < charStr.length; i++) {
            charStr[i] = stack.pop();
        }

        result = String.copyValueOf(charStr);
        return result;
    }
}
