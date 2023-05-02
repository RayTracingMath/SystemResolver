

public abstract class DeterminantResolver {
    


    public double calculate(double[][] matrix) throws Exception{
        //check if the matrix is square
        if (matrix.length != matrix[0].length) {
            throw new Exception("The matrix is not square.");
        }

        return algorithm(matrix);
    }

    abstract double algorithm(double[][] matrix) throws Exception;

}
