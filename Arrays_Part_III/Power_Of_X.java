/*
    Problem Name: Pow(x, n)
    Problem Link: https://leetcode.com/problems/powx-n/description/
*/

public class Power_Of_X {
    /*
        Brute Force Approach
        TC -> O(N)
        SC -> O(1)
        public static double myPow(double x, int n) {
            double ans = 1.0;
            boolean isNegative = false;
            if(n < 0){
                isNegative = true;
                n *= -1;
            }
            for(int i=1;i<=n;i++){
                ans *= x;
            }
            if(isNegative)  ans = 1.0/ans;
            return ans;
        }
    */

    /*
        Optimal Solution
        TC -> O(logN)
        SC -> O(1)
    */
    public static double myPow(double x, int n) {
        long nTemp = n;
        double ans = 1.0;
        boolean isNegative = false;
        if(nTemp < 0){
            isNegative = !isNegative;
            nTemp = -nTemp;
        }
        while(nTemp > 0){
            if(nTemp % 2 == 0){
                x = x * x ;
                nTemp = nTemp / 2;
            }else{
                ans *= x;
                nTemp -= 1; 
            }
        }        
        if(isNegative){
            ans = (double)1.0 / (double)ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test Cases
        double x1 = 2.0, x2 = 2.1, x3 = 2.0;
        int n1 = 10, n2 = 3, n3 = -2;

        System.out.println(myPow(x1, n1));
        System.out.println(myPow(x2, n2));
        System.out.println(myPow(x3, n3));
    }
}
