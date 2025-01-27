
package org.example;
import no.uib.cipr.matrix.DenseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogisticRegression extends Model{


    public LogisticRegression(CostFunction costFunction, Optimizer optimizer) {
        super(costFunction, optimizer);
        this.costFunction = costFunction;
        this.optimizer = optimizer;

    }


}


