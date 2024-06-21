import java.util.Arrays;

public class Set_Matrix_Zeros{
    /*
        Brute Force
        TC -> O(N * M) * (N + M) -> nearly O(N^3)
        SC -> O(1)
        public static void setZeroes(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j] == 0){
                        markRow(matrix, i);
                        markCol(matrix, j);
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j] == -1){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        public static void markRow(int[][] matrix, int row){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[row][j] != 0){
                    matrix[row][j] = -1;
                }
            }
        }

        public static void markCol(int[][] matrix, int col){
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][col] != 0){
                    matrix[i][col] = -1;
                }
            }
        }
    */

    /* 
        Better Solution
        TC -> O(N * M) + O(N * M) -> 2O(N * M)
        SC -> O(N + M )
        public static void setZeroes(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            int[] row = new int[n];
            int[] col = new int[m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j] == 0){
                        row[i] = 1;
                        col[j] = 1;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(row[i] == 1 || col[j] == 1){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    */

    /*
        Optimal Solution
        TC -> O(N * M) + O(N * M) -> 2O(N * M)
        SC -> O(1)
    */
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        // int[] row = new int[n];   ->   matrix[..][0]
        // int[] col = new int[m];   ->   matrix[0][..]
        int col0 = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        for(int i=n-1;i>=1;i--){
            for(int j=m-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args){
        // Test Cases
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        display(matrix1);

        int[][] matrix2 = {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}};
        setZeroes(matrix2);
        display(matrix2);
    }

    public static void display(int[][] matrix){
        for(int[] arr: matrix){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("-----------------------------------------------------------");
    }
}