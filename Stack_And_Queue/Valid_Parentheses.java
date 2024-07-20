/*
    Problem Name: Valid Parentheses
    Problem Link: https://leetcode.com/problems/valid-parentheses/
*/

import java.util.Stack;

public class Valid_Parentheses {
    /*
        There is no Brute, better, Optimal Solution for this. It's just a easy problem!
        TC -> O(N)
        SC -> O(N)
    */
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty())    return false;

                if((ch == ')' && st.peek() == '(') || (ch == ']' && st.peek() == '[') || ch == '}' && st.peek() == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        // Test Cases
        String s1 = "()", s2 = "()[]{}", s3 = "(]";
        
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }
}