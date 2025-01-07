package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class JMatrix {


    public DenseMatrix create(double[][] entry) {

        int rows = entry.length;
        int cols = entry[0].length;

        DenseMatrix denseMatrix = new DenseMatrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                denseMatrix.set(i, j, entry[i][j]);
            }
        }

        return denseMatrix;

    }

    public DenseMatrix transpose(DenseMatrix denseMatrix) {

        DenseMatrix transposed = new DenseMatrix(denseMatrix.numColumns(), denseMatrix.numRows());
        for (int i = 0; i < denseMatrix.numRows(); i++) {
            for (int j = 0; j < denseMatrix.numColumns(); j++) {
                transposed.set(j, i, denseMatrix.get(i, j));
            }
        }

        return transposed;
    }

    public DenseMatrix multiply(DenseMatrix A, DenseMatrix B) {

        if (A.numColumns() != B.numRows()) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        DenseMatrix result = new DenseMatrix(A.numRows(), B.numColumns());

        A.mult(B, result);

        return result;
    }

    public DenseMatrix subtract(DenseMatrix A, DenseMatrix B) {

        if (A.numRows() != B.numRows() || A.numColumns() != B.numColumns()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        DenseMatrix result = new DenseMatrix(A.numRows(), A.numColumns());

        for (int i = 0; i < A.numRows(); i++) {
            for (int j = 0; j < A.numColumns(); j++) {
                result.set(i, j, A.get(i, j) - B.get(i, j));
            }
        }

        return result;
    }

    public void printMatrix(DenseMatrix denseMatrix) {

        for (int i = 0; i < denseMatrix.numRows(); i++) {
            for (int j = 0; j < denseMatrix.numColumns(); j++) {
                System.out.print(denseMatrix.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
