package org.example;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.SymmDenseEVD;

public class CrossEntropy implements CostFunction{

    private HypothesisFunction hypothesisFunction;
    private boolean normalize;

    public CrossEntropy(HypothesisFunction hypothesisFunction, boolean normalize) {

        this.hypothesisFunction = hypothesisFunction;
        this.normalize = normalize;

    }

    @Override
    public double compute(Dataset dataset, double[][] parameters) {

        int m = dataset.getInstances().size();
        DenseMatrix matrixX;
        double J = 0.0;
        JMatrix operations = new JMatrix();

        DenseMatrix y = operations.create(operations.array1Dto2D(dataset.generateLabelArray()));

        double[][] grad = new double[parameters.length][parameters[0].length];
        DenseMatrix theta = operations.create(parameters);

        if (normalize) matrixX = operations.create(dataset.generateDesignMatrixNormalized());
        else matrixX = operations.create(dataset.generateDesignMatrix());

        DenseMatrix computed = hypothesisFunction.compute(dataset, operations.convertToArray(theta));

        DenseMatrix cost = operations.multiply(operations.transpose(y), operations.elementWiseLog(computed));
        DenseMatrix aux = operations.transpose(operations.addScalarToMatrix((DenseMatrix) y.scale(-1.0), 1));
        aux = operations.multiply(aux, operations.elementWiseLog(operations.addScalarToMatrix((DenseMatrix)computed.scale(-1.0), 1)));
        cost = operations.add(cost, aux);
        J = cost.get(0, 0);
        //System.out.println(J);
        return J;

    }

}
