
package org.example;
import no.uib.cipr.matrix.DenseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearRegression extends Model{

    private CostFunction costFunction;
    private Optimizer optimizer;

    public LinearRegression(CostFunction costFunction, Optimizer optimizer) {
        //super();
        this.costFunction = costFunction;
        this.optimizer = optimizer;

    }

    public void fit(Dataset data, double[][] parameters) {

        optimizer.compute(data, costFunction, parameters);

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


