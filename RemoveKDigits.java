import java.util.Arrays;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Handle the case where k > 0, remove remaining largest digits
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Construct the answer from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeroes
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String num = "10200";
        int k = 1;
        System.out.println(solution.removeKdigits(num, k)); // Output: "200"
    }
}