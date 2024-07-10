/*
    Problem Name: Minimum Coins
    Problem Link: https://www.naukri.com/code360/problems/minimum-coins_982764
*/

public class Minimum_Coins {
    /*
        Optimal Solution
        TC -> O(V) in the worst case
        SC -> O(1)
    */
    public static int minimumCoins(int V){
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int count = 0;
        int i = coins.length - 1;
        while(V > 0){
            if(coins[i] <= V){
                V -= coins[i];
                count += 1;
            }else{
                i--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // Test Cases
        int V1 = 60, V2 = 10, V3 = 24, V4 = 200;
        System.out.println(minimumCoins(V1));
        System.out.println(minimumCoins(V2));
        System.out.println(minimumCoins(V3));
        System.out.println(minimumCoins(V4));
    }
}
