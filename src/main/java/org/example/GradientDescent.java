package org.example;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;

public class GradientDescent implements Optimizer {

    private double learningRate;
    private int iterations;
    private boolean normalize;

    public GradientDescent(double learningRate, int iterations, boolean normalize) {

        this.learningRate = learningRate;
        this.iterations = iterations;
        this.normalize = normalize;

    }

    @Override
    public double[][] compute(Dataset dataset, HypothesisFunction hypothesisFunction, double[][] parameters) {


        int m = dataset.getInstances().size();
        double[] J_history = new double[iterations];
        JMatrix operations = new JMatrix();
        DenseMatrix matrixTheta = operations.create(parameters);

        for (int iter = 0; iter < iterations; iter++) {

            DenseMatrix matrixX;

            if (normalize) matrixX = operations.create(dataset.generateDesignMatrixNormalized());
            else matrixX = operations.create(dataset.generateDesignMatrix());


            DenseMatrix matrixH = hypothesisFunction.compute(dataset, parameters);

            double[][] labelArray = {dataset.generateLabelArray()};
            DenseMatrix matrixY = operations.create(labelArray);
            DenseMatrix prediction = operations.subtract(matrixH, operations.transpose(matrixY));
            prediction = operations.transpose(prediction);
            prediction = operations.multiply(prediction, matrixX);
            prediction = operations.transpose(prediction);
            prediction.scale(learningRate / m);

            matrixTheta = operations.subtract(matrixTheta, prediction);
            //operations.printMatrix(matrixTheta);

        }

        return operations.convertToArray(matrixTheta);



    }

}
