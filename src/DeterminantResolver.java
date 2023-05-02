

public class DeterminantResolver {
    


    

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static double laplace(double[][] matrix) {
        double result = 0;
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        for (int i = 0; i < n; i++) {
            result += Math.pow(-1, i) * matrix[0][i] * laplace(minor(matrix, 0, i));
        }
        return result;
    }


    private static double[][] minor(double[][] matrix, int i, int i2) {

        int n = matrix.length;
        double[][] result = new double[n - 1][n - 1];
        int row = 0;
        int col = 0;
        for (int j = 0; j < n; j++) {
            if (j != i) {
                for (int k = 0; k < n; k++) {
                    if (k != i2) {
                        result[row][col] = matrix[j][k];
                        col++;
                    }
                }
                row++;
                col = 0;
            }
        }
        return result;
        
    }
}
