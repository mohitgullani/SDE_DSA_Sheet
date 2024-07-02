import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    /*
        Brute Force Approach
        TC -> O(N^3)
        SC -> O(N)
        public static int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int n = s.length();
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    HashSet<Character> set = new HashSet<>();
                    for(int k=i;k<=j;k++){
                        set.add(s.charAt(k));
                    }
                    if(set.size() == j - i + 1){
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
            return maxLength;
        }
    */

    /*
        Better Solution
        TC -> O(N^2)
        SC -> O(N)
        public static int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int n = s.length();
            for(int i=0;i<n;i++){
                HashSet<Character> set = new HashSet<>();
                for(int j=i;j<n;j++){
                    set.add(s.charAt(j));
                    if(set.size() == j - i + 1){
                        maxLength = Math.max(maxLength, j - i + 1);
                    }else{
                        break;
                    }
                }
            }
            return maxLength;
        }
    */

    /*
        Optimal Solution
        TC -> O(2N), linear Time Complexity
        SC -> O(N) for the set data structure
    */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                right++;
                maxLength = Math.max(maxLength, right - left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        // Test Cases
        String s1 = "abcabcbb", s2 = "bbbbb", s3 = "pwwkew";
        
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
