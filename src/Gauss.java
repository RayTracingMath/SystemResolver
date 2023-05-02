public class Gauss extends SystemResolver{
    
    
    public double[] algorithm(double[][] incompleteMatrix, double[] result) throws Exception {
        int n = incompleteMatrix.length;
        
        
        double[][] matrix = new double[n][n+1]; // augmented matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = incompleteMatrix[i][j];
            }
            matrix[i][n] = result[i];
        }
        
        // Gauss elimination
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i+1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])) {
                    pivot = j;
                }
            }
            
            if (matrix[pivot][i] == 0) {
                throw new Exception("The system has not a unique solution.");
            }
            
            if (pivot != i) {
                double[] temp = matrix[pivot];
                matrix[pivot] = matrix[i];
                matrix[i] = temp;
            }
            
            for (int j = i+1; j <= n; j++) {
                matrix[i][j] /= matrix[i][i];
            }
            
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    for (int k = i+1; k <= n; k++) {
                        matrix[j][k] -= matrix[j][i] * matrix[i][k];
                    }
                }
            }
        }
        
        double[] solution = new double[n]; 
        for (int i = 0; i < n; i++) {
            solution[i] = matrix[i][n];
        }
        
        return solution;
    }
}
