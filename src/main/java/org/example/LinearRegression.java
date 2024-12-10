
package org.example;
import no.uib.cipr.matrix.DenseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearRegression implements CostFunction, GradientDescent, DataPrep {

    private String pathfile;
    private double[][] X;
    private double[] y;
    private double alpha;
    private int iterations;
    private double[][] theta = {{0.0},{0.0}};

    public LinearRegression(String pathfile, double alpha, int iterations) {

        this.pathfile = pathfile;
        this.alpha = alpha;
        this.iterations = iterations;

    }

    @Override
    public double computeCostFunction() {

        int m = this.y.length;
        double J = 0.0;
        DenseMatrix matrixX = new DenseMatrix(this.X);
        DenseMatrix matrixTheta = new DenseMatrix(this.theta);

        DenseMatrix matrixH = new DenseMatrix(matrixX.numRows(), matrixTheta.numColumns());
        matrixX.mult(matrixTheta, matrixH);


        for (int i = 0; i < matrixH.numRows(); i++) {

            double value = matrixH.get(i, 0) - this.y[i];

            J += value * value;

        }

        J *= 1.0 / (2.0 * m);

        //System.out.println(J);

        return J;

    }

    public void computeGradientDescent() {

        int m = this.y.length;
        double[] J_history = new double[this.iterations];

        for (int iter = 0; iter < this.iterations; iter++) {

            DenseMatrix matrixX = new DenseMatrix(this.X);
            DenseMatrix matrixTheta = new DenseMatrix(this.theta);

            DenseMatrix matrixH = new DenseMatrix(matrixX.numRows(), matrixTheta.numColumns());
            matrixX.mult(matrixTheta, matrixH);


            double hmy = 0.0;
            double hmyx = 0.0;

            for (int i = 0; i < matrixH.numRows(); i++) {

                for (int j = 0; j < matrixH.numColumns(); j++) {

                    double value1 = this.X[i][0] * (matrixH.get(i, j) - this.y[i]);
                    double value2 = this.X[i][1] * (matrixH.get(i, j) - this.y[i]);

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

    @Override
    public void preparation() throws FileNotFoundException {


        int textFileLength;
        Scanner infile = new Scanner(new File(this.pathfile));

        textFileLength = infile.nextInt();
        this.X = new double[textFileLength][2];
        this.y = new double[textFileLength];
        for (int i = 0; i < textFileLength; i++) {

            X[i][0] = 1.0;
            X[i][1] = infile.nextDouble();
            y[i] = infile.nextDouble();

        }

        infile.close();

        double[] noIntercept = new double[textFileLength];
        for (int j = 0; j < textFileLength; j++) {

            noIntercept[j] = this.X[j][1];

        }

        //SwingUtilities.invokeLater(() -> {
        Plotter myPlot = new Plotter();
        myPlot.ScatterPlot(noIntercept, this.y);
        myPlot.setSize(800, 600);
        myPlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPlot.setVisible(true);
        //});

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


}


