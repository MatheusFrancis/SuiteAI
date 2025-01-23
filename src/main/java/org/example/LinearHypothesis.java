package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class LinearHypothesis implements HypothesisFunction {

    private boolean normalize;

    public LinearHypothesis(boolean normalize) {

        this.normalize = normalize;

    }


    @Override
    public DenseMatrix compute(Dataset dataset, double[][] theta) {

        DenseMatrix matrixX;
        JMatrix operations = new JMatrix();

        if (normalize) matrixX = operations.create(dataset.generateDesignMatrixNormalized());
        else matrixX = operations.create(dataset.generateDesignMatrix());

        DenseMatrix matrixTheta = operations.create(theta);
        System.out.println("Matrix X: ");
        operations.printMatrix(matrixX);
        System.out.println("Matrix Theta: ");
        operations.printMatrix(matrixTheta);

        return operations.multiply(matrixX, matrixTheta);

    }
}
