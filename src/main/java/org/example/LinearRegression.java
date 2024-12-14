
package org.example;
import no.uib.cipr.matrix.DenseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearRegression implements CostFunction, GradientDescent {

    private Dataset dataset;
    private double alpha;
    private int iterations;
    private double[][] theta = {{0.0},{0.0}};

    public LinearRegression(Dataset data, double alpha, int iterations) {

        this.dataset = data;
        this.alpha = alpha;
        this.iterations = iterations;

    }

    public DenseMatrix hypothesisFunction() {

        DenseMatrix matrixX = new DenseMatrix(dataset.generateDesignMatrix());
        DenseMatrix matrixTheta = new DenseMatrix(theta);

        DenseMatrix matrixH = new DenseMatrix(matrixX.numRows(), matrixTheta.numColumns());
        matrixX.mult(matrixTheta, matrixH);

        return matrixH;

    }

    @Override
    public double computeCostFunction() {


        int m = dataset.getInstances().size();
        double J = 0.0;
        DenseMatrix matrixH = hypothesisFunction();



        for (int i = 0; i < matrixH.numRows(); i++) {

            double value = matrixH.get(i, 0) - dataset.getInstances().get(i).getLabel().getValue();

            J += value * value;

        }

        J *= 1.0 / (2.0 * m);

        return J;

    }

    public void computeGradientDescent() {

        int m = dataset.getInstances().size();
        double[] J_history = new double[this.iterations];

        for (int iter = 0; iter < this.iterations; iter++) {

            DenseMatrix matrixH = hypothesisFunction();


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

            double temp1 = theta[0][0] - (this.alpha * hmy);
            double temp2 = theta[1][0] - (this.alpha * hmyx);
            theta[0][0] = temp1;
            theta[1][0] = temp2;
            J_history[iter] = computeCostFunction();




        }


        System.out.println(theta[0][0]);
        System.out.println(theta[1][0]);


    }

    /*
    @Override
    public void preparation() throws FileNotFoundException {


        DenseMatrix matrixX = new DenseMatrix(this.X);
        DenseMatrix matrixTheta = new DenseMatrix(this.theta);

        DenseMatrix matrixH = new DenseMatrix(matrixX.numRows(), matrixTheta.numColumns());
        matrixX.mult(matrixTheta, matrixH);


        int rows = matrixH.numRows();
        double[] matrixHConvertedToArray = new double[rows];

        for (int i = 0; i < rows; i++) {
            matrixHConvertedToArray[i] = matrixH.get(i, 0); // Extract the element at (i, 0)
        }


        //SwingUtilities.invokeLater(() -> {
        Plotter myPlot2 = new Plotter();
        myPlot2.LinearPlot(noIntercept, matrixHConvertedToArray);
        myPlot2.setSize(800, 600);
        myPlot2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPlot2.setVisible(true);
        //});


    }

*/
}


