import java.util.Arrays;
import java.util.Stack;
//https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/
public class MInMaxDiifSubarray {
    
    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] NSEL = findNSEL(A);
        int[] NSER = findNSER(A);
        int[] NGEL = findNGEL(A);
        int[] NGER = findNGER(A);

        int n = A.length;
        int mod = 1000000007;

        long totalMax = 0l, totalMin = 0l;

        for(int i = 0; i < n; i++){
            //number of subarrays where A[i] will be maximum
            long maxSubarrayCount = 1l * (NGER[i] - i) * (i - NGEL[i]);
            long currentMaxContri = (A[i] * maxSubarrayCount) % mod;

            //number of subarrays where A[i] will be minimum
            long minSubarrayCount = 1l * (NSER[i] - i) * (i - NSEL[i]);
            long currentMinContri = (A[i] * minSubarrayCount) % mod;

            //generating total max contribution and minimum contribution
            totalMax = ((currentMaxContri % mod) + (totalMax % mod)) % mod;
            totalMin = ((currentMinContri % mod) + (totalMin % mod)) % mod;
        }

        int sum = (int)(totalMax - totalMin) % mod;
        System.out.println((sum + mod) % mod);
    }
    
    public static int[] findNSEL(int[] A){
        int n = A.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        ans[0] = -1;
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if(stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int[] findNSER(int[] A){
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        ans[n-1] = n;
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if(stack.isEmpty())
                ans[i] = n;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int[] findNGEL(int[] A){
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        ans[0] = -1;
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if(stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static  int[] findNGER(int[] A){
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        ans[n-1] = n;
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if(stack.isEmpty())
                ans[i] = n;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
