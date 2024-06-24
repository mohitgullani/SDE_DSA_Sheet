import java.util.Arrays;

public class Repeat_And_Missing_Number {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int[] getRepeatAndMissing(int[] nums){
            int missing = -1, repeating= -1;
            for(int i=1;i<=nums.length;i++){
                int count = 0;
                for(int j=0;j<nums.length;j++){
                    if(nums[j] == i){
                        count++;
                    }
                }
                if(count == 2){
                    repeating = i;
                }else if(count == 0){
                    missing = i;
                }

                if(missing != -1 && repeating != -1){
                    break;
                }
            }
            return new int[]{repeating, missing};
        }
    */

    /*
        Better Solution
        TC -> O(2N)
        SC -> O(N)
        public static int[] getRepeatAndMissing(int[] nums){
            int missing = -1, repeating= -1;
            int[] hash = new int[nums.length + 1];
            for(int i=0;i<nums.length;i++){
                hash[nums[i]]++;
            }
            for(int i=1;i<hash.length;i++){
                if(hash[i] == 2){
                    repeating = i;
                }else if(hash[i] == 0){
                    missing = i;
                }

                if(missing != -1 && repeating != -1){
                    break;
                }
            }
            return new int[]{repeating, missing};
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static int[] getRepeatAndMissing(int[] nums){
        int n = nums.length;
        long SN = n * (n + 1)/2;
        long S2N = n * (n + 1) * (2*n + 1)/6;
        long S = 0, S2 = 0;
        for(int num: nums){
            S += (long) num;
            S2 += (long) num * (long) num;
        }
        
        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2)/2;
        long y = x - val1;
        return new int[]{(int)x, (int)y};
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums = {1,6,2,3,1,4};
        System.out.println(Arrays.toString(getRepeatAndMissing(nums)));
    }  
}
