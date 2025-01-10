package org.example;
import java.lang.Math;

public class StatisticalMatrix {

    public double[] matrixMean(double[][] matrix) {

        int numRows = matrix.length;
        int numColumns = matrix[0].length - 1;

        double[] mean = new double[numColumns];

        for (int i = 0; i < numColumns; i++) {   //preserve the intercept column

            for (int j = 0; j < numRows; j++) {

                mean[i] += matrix[j][i + 1];

            }

            mean[i] /= numRows + 1;

        }


        return mean;

    }

    public double[] matrixStandardDeviation(double[][] matrix) {

        int numRows = matrix.length;
        int numColumns = matrix[0].length - 1;

        double[] mean = matrixMean(matrix);
        double[] std = new double[numColumns];

        for (int i = 0; i < numColumns; i++) {

            for (int j = 0; j < numRows; j++) {

                std[i] += (matrix[j][i + 1] - mean[i]) * (matrix[j][i + 1] - mean[i]);

            }

            std[i] /= numRows + 1;
            std[i] = Math.sqrt(std[i]);


        }

        return std;

    }
}
