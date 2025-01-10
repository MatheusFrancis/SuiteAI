package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class LinearHypothesis implements HypothesisFunction {

    private boolean normalize;

    public LinearHypothesis(boolean normalize) {

        this.normalize = normalize;

    }

    public DenseMatrix compute2(Dataset dataset, double[][] theta) {

        DenseMatrix matrixX;

        if (normalize) matrixX = new DenseMatrix(dataset.generateDesignMatrixNormalized());
        else matrixX = new DenseMatrix(dataset.generateDesignMatrix());

        DenseMatrix matrixTheta = new DenseMatrix(theta);

        DenseMatrix matrixH = new DenseMatrix(matrixX.numRows(), matrixTheta.numColumns());
        matrixX.mult(matrixTheta, matrixH);

        return matrixH;

    }

    @Override
    public DenseMatrix compute(Dataset dataset, double[][] theta) {

        DenseMatrix matrixX;
        JMatrix operations = new JMatrix();

        if (normalize) matrixX = operations.create(dataset.generateDesignMatrixNormalized());
        else matrixX = operations.create(dataset.generateDesignMatrix());

        DenseMatrix matrixTheta = operations.create(theta);


        return operations.multiply(matrixX, matrixTheta);

    }
}
