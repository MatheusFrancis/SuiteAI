package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class MSE implements CostFunction {


    @Override
    public double compute(Dataset dataset, double[][] parameters) {

        int m = dataset.getInstances().size();
        double J = 0.0;
        HypothesisFunction linear = new LinearHypothesis();
        DenseMatrix matrixH = linear.compute(dataset, parameters);

        for (int i = 0; i < matrixH.numRows(); i++) {

            double value = matrixH.get(i, 0) - dataset.getInstances().get(i).getLabel().getValue();

            J += value * value;

        }

        J *= 1.0 / (2.0 * m);

        return J;

    }
}
