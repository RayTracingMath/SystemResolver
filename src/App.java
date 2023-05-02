public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("insert the number of unknowns");
        int n = Integer.parseInt(System.console().readLine());
        double[][] incompleteMatrix = new double[n][n];
        System.out.println("insert the incomplete matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("insert the value of the %d,%d element\n", i + 1, j + 1);
                incompleteMatrix[i][j] = Double.parseDouble(System.console().readLine());
            }
        }

        System.out.println("insert the result vector");
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.format("insert the value of the %d element\n", i + 1);
            result[i] = Double.parseDouble(System.console().readLine());
        }

        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(incompleteMatrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = result[i];
        }
        
        double determinant = DeterminantResolver.laplace(incompleteMatrix);
        if (determinant == 0) {
            System.out.println("the determinant is 0, the system has infinite solutions or no solutions");
            return;
        }

        double[] solutions = new double[n];

        //let's use the cramer method
        double[] determinantVector = new double[n];

        for (int i = 0; i < n; i++) {
            //first let's make a copy of the incomplete matrix
            double[][] tempMatrix = new double[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(incompleteMatrix[j], 0, tempMatrix[j], 0, n);
            }

            //now let's replace the i-th column with the result vector
            for (int j = 0; j < n; j++) {
                tempMatrix[j][i] = result[j];
            }

            determinantVector[i] = DeterminantResolver.laplace(tempMatrix);
        }

        for (int i = 0; i < n; i++) {
            solutions[i] = determinantVector[i] / determinant;
        }

        System.out.println("the solutions are:");
        for (int i = 0; i < n; i++) {
            System.out.format("x%d = %f\n", i + 1, solutions[i]);
        }
    }
}
