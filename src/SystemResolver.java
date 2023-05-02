public abstract class SystemResolver {
    double[] calculate(double[][] incompleteMatrix, double[] result) throws Exception{
        //check if the matrix is square
        if (incompleteMatrix.length != incompleteMatrix[0].length) {
            throw new Exception("The matrix is not square.");
        }

        //check if the result vector has the same length of the matrix
        if (incompleteMatrix.length != result.length) {
            throw new Exception("The result vector has not the same length of the matrix.");
        }

        return algorithm(incompleteMatrix, result);
    }

    abstract double[] algorithm(double[][] matrix, double[] result) throws Exception;
}
