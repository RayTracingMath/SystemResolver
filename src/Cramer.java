public class Cramer extends SystemResolver{

    @Override
    public double[] algorithm(double[][] incompleteMatrix, double[] result) throws Exception {
        int n = incompleteMatrix.length;

        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(incompleteMatrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = result[i];
        }

        double determinant = new Laplace().calculate(augmentedMatrix);
        if (determinant == 0) {
            System.out.println("the determinant is 0, the system has infinite solutions or no solutions");
            return null;
        }

        double[] solutions = new double[n];

        //let's use the Cramer method
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

            determinantVector[i] = new Laplace().calculate(tempMatrix);
        }

        for (int i = 0; i < n; i++) {
            solutions[i] = determinantVector[i] / determinant;
        }

        return solutions;
    }
    
}
