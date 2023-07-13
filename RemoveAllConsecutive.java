import java.util.Stack;

public class RemoveAllConsecutive{
    public static void main(String[] args) {
        
    
        String  A = "cddfeffe";

        System.out.println(removeDoubleChar(A));

    }
    public static String removeDoubleChar(String A){
         Stack<Character> carryNonDub = new Stack<>();

        for(int i=0; i<A.length(); i++){
            char currChar = A.charAt(i);
            if(carryNonDub.isEmpty()){
                carryNonDub.push(currChar);
            }else if(!carryNonDub.isEmpty() && currChar == carryNonDub.peek()){
                carryNonDub.pop();
            }else{
                carryNonDub.push(currChar);
            }
        }

        //we have left with stack with unique elements 
        StringBuilder ans = new StringBuilder();
        while(!carryNonDub.isEmpty()){
            ans.append(carryNonDub.pop());
        }
        System.out.println(ans);

        String result = new String(ans.reverse());

        

        return result;


        //we can solve this in O(N)TC and SC O(1)
        // by just using string builder add first element in stringBuilder sb iterate to String s from index 1 and 
        // if (sb(i-1) == s(i)){
        //     remove from string buikder
        // }else{
        //     append the char
        //}
    }
}