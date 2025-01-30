
package org.example;
import no.uib.cipr.matrix.DenseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearRegression extends Model{


    public LinearRegression(HypothesisFunction hypothesisFunction, Optimizer optimizer) {
        super(hypothesisFunction, optimizer);
        this.hypothesisFunction = hypothesisFunction;
        this.optimizer = optimizer;

    }


}


