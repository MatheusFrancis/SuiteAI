package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public class GradientDescent implements Optimizer {

    private double learningRate;
    private int iterations;

    public GradientDescent(double learningRate, int iterations) {

        this.learningRate = learningRate;
        this.iterations = iterations;

    }

    @Override
    public void compute(Dataset dataset, CostFunction costFunction, double[][] parameters) {

        int m = dataset.getInstances().size();
        double[] J_history = new double[iterations];

        for (int iter = 0; iter < iterations; iter++) {

            HypothesisFunction linear = new LinearHypothesis();
            DenseMatrix matrixH = linear.compute(dataset, parameters);


            double hmy = 0.0;
            double hmyx = 0.0;

            for (int i = 0; i < matrixH.numRows(); i++) {

                for (int j = 0; j < matrixH.numColumns(); j++) {

                    double value1 = dataset.generateDesignMatrix()[i][0] * (matrixH.get(i, j) -
                            dataset.getInstances().get(i).getLabel().getValue());

                    double value2 = dataset.generateDesignMatrix()[i][1] * (matrixH.get(i, j) -
                            dataset.getInstances().get(i).getLabel().getValue());

                    hmy+= value1;
                    hmyx += value2;


                }

            }

            hmy /= m;
            hmyx /= m;

            double temp1 = parameters[0][0] - (learningRate * hmy);
            double temp2 = parameters[1][0] - (learningRate * hmyx);
            parameters[0][0] = temp1;
            parameters[1][0] = temp2;

            CostFunction lossFunction = new MSE();
            J_history[iter] = lossFunction.compute(dataset, parameters);





        }


        System.out.println(parameters[0][0]);
        System.out.println(parameters[1][0]);



    }

}
