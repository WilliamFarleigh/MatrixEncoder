import java.util.*;
import java.io.*;
public class MyProgram {
    public static void main(String[] args) {
        MatrixEncoder matrixEncoder = new MatrixEncoder(getSizeOfMatrix());
        Matrix matrix = matrixEncoder.getMatrix();
        Inverse inverse = matrixEncoder.getInverse();

        Matrix encoded = matrixEncoder.encode(getEncodedWord());
        System.out.println(encoded.toString()  + "\n" + matrixEncoder.decode(encoded));
        System.out.println("Matrix: \n" + matrix.toString());
        System.out.println("Inverse Matrix: \n" + inverse.toString());
    }
    public static String getEncodedWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("what would you like to encode in a matrix? ");
        try {
            return scanner.nextLine();
        } catch(InputMismatchException e) {
            e.printStackTrace();
            return getEncodedWord();
        }
    }
    public static int getSizeOfMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("what size would you like your matrix? ");
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Please input a valid matrix size!");
            return getSizeOfMatrix();
        }
    }
}