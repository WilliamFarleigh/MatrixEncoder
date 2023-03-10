public class MatrixEncoder {
    private Matrix matrix;
    private Inverse inverse;
    
    public MatrixEncoder() {
        this.matrix = new Matrix();
        this.inverse = matrix.findInverse();
    }
    public MatrixEncoder(int size) {
        this.matrix = new Matrix(size);
        this.inverse = matrix.findInverse();
    }
    public MatrixEncoder(Matrix matrix) {
        this.matrix = new Matrix(matrix);
        this.inverse = matrix.findInverse();
    }
    
    public MatrixEncoder(double[][] matrixAsArr) {
        this.matrix = new Matrix(matrixAsArr);
        this.inverse = matrix.findInverse();
    }
    
    public Matrix encode(String str) {
        double[][] characterMatrix = new double[str.length()/matrix.getYLength() + 1][matrix.getXLength()];
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            
            characterMatrix[i / (characterMatrix[0].length)][i % characterMatrix[0].length] = charArr[i];
        }
        Matrix newMatrix = new Matrix(characterMatrix);
        Matrix copyMatrix = matrix.multiplyMatrix(newMatrix);
        return copyMatrix;
    }
    public String decode(Matrix inputMatrix) {
        Matrix copyMatrix = inverse.multiplyMatrix(inputMatrix);
        double[][] copyMatrixAsArray = copyMatrix.getMatrixAsArray();
        StringBuilder builder = new StringBuilder();
        for (double[] row : copyMatrixAsArray) {
            for (double val : row) {
                builder.append(Character.valueOf((char) ((int) (val + 0.5))));
            }
        }
        return builder.toString();
    }

    public Inverse getInverse() {
        return this.inverse;
    }
    public Matrix getMatrix() {
        return this.matrix;
    }

}