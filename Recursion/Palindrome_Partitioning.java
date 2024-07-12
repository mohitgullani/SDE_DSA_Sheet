/*
    Problem Name: Palindrome Partitioning
    Problem Link: https://leetcode.com/problems/palindrome-partitioning/
*/

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    /*
        Recursive Approach
        TC -> O(N * (2^N))
        SC -> O(N), recursive stack space
    */
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partitionHelper(0, s, new ArrayList<>(), list);
        return list;
    }

    public static void partitionHelper(int index, String s, List<String> ds, List<List<String>> list){
        if(index == s.length()){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                ds.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, ds, list);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aab", s2 = "a", s3 = "aabb";
        
        System.out.println(partition(s1));
        System.out.println(partition(s2));
        System.out.println(partition(s3));
    }
}