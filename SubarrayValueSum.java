import java.util.*;

public class SubarrayValueSum {
    public static int MOD = 1000000007;
    
    public static int sumSubarrayValues(int[] A) {
        int n = A.length;
        long totalSum = 0;
        
        // Calculate prefix sums array
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = (prefixSum[i - 1] + A[i]) % MOD;
        }
        
        // Calculate suffix sums array
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = (suffixSum[i + 1] + A[i]) % MOD;
        }
        
        // Calculate sum of values for each subarray
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + ((long) A[i] * (i + 1) * (n - i)) % MOD) % MOD;
        }
        
        // Subtract sum of values excluded in each subarray
        for (int i = 0; i < n - 1; i++) {
            totalSum = (totalSum - ((long) prefixSum[i] * (n - i - 1)) % MOD + MOD) % MOD;
            totalSum = (totalSum - ((long) suffixSum[i + 1] * (i + 1)) % MOD + MOD) % MOD;
        }
        
        return (int) totalSum;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int sum = sumSubarrayValues(A);
        System.out.println("Sum of values of all possible subarrays: " + sum);
    }
}