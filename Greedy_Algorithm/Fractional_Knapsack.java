/*
    Problem Name: Fractional Knapsack
    Problem Link: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
*/

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    /*
        Optimal solution
        TC -> O(NlogN) + O(N)
        SC -> O(1)
    */
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>(){
           @Override
           public int compare(Item item1, Item item2){
               double rate1 = (double)item1.value / (double)item1.weight;
               double rate2 = (double)item2.value / (double)item2.weight;
               if(rate1 < rate2){
                    return 1;
               }else{
                   return -1;
               }
           }
        });
        
        double totalProfit = 0.0;
        for(Item item: arr){
            if(item.weight <= W){
                totalProfit += item.value;
                W -= item.weight;
            }else{
                double rate = (double)item.value / (double)item.weight;
                totalProfit += (rate * (double)(W));
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        // Test Cases
        int W1 = 50, W2 = 50, n1 = 3, n2 = 2;
        int[] value1 = {60, 100, 120}, value2 = {60, 100};
        int[] weight1 = {10, 20, 30}, weight2 = {10, 20};

        Item[] item1 = new Item[n1];
        Item[] item2 = new Item[n2];

        for(int i=0;i<n1;i++){
            item1[i] = new Item(value1[i], weight1[i]);
        }

        for(int i=0;i<n2;i++){
            item2[i] = new Item(value2[i], weight2[i]);
        }

        System.out.println(fractionalKnapsack(W1, item1, n1));
        System.out.println(fractionalKnapsack(W2, item2, n2));
    }

    public static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
