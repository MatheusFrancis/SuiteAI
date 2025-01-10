
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

    public double[][] fit(Dataset data, double[][] parameters) {

        return optimizer.compute(data, costFunction, parameters);

    }

}


