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
        //operations.printMatrix(matrixX);
        //operations.printMatrix(matrixTheta);
        System.out.println(matrixX.numRows());
        System.out.println(matrixX.numColumns());
        System.out.println(matrixTheta.numRows());
        System.out.println(matrixTheta.numColumns());


        return operations.multiply(matrixX, matrixTheta);

    }
}
