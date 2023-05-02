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

        

        SystemResolver solver = new Gauss();
        double[] solutions = solver.calculate(incompleteMatrix, result);
        if (solutions == null) {
            System.out.println("the determinant is 0, the system has infinite solutions or no solutions");
            return;
        }

        System.out.println("the solutions are:");
        for (int i = 0; i < n; i++) {
            System.out.format("x%d = %f\n", i + 1, solutions[i]);
        }
    }
}
