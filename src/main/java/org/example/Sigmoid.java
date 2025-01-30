package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class Sigmoid implements HypothesisFunction {

    private boolean normalize;

    public Sigmoid(boolean normalize) {

        this.normalize = normalize;

    }


    @Override
    public DenseMatrix compute(Dataset dataset, double[][] theta) {

        DenseMatrix matrixX;
        JMatrix operations = new JMatrix();

        if (normalize) matrixX = operations.create(dataset.generateDesignMatrixNormalized());
        else matrixX = operations.create(dataset.generateDesignMatrix());

        DenseMatrix matrixTheta = operations.create(theta);
        DenseMatrix first = operations.multiply(operations.transpose(matrixTheta), operations.transpose(matrixX));

        first = operations.transpose(first);

        DenseMatrix second = operations.elementWiseExp((DenseMatrix) first.scale(-1.0));

        DenseMatrix third = operations.addScalarToMatrix(second, 1.0);

        return operations.elementWiseInverse(third);

    }

}

