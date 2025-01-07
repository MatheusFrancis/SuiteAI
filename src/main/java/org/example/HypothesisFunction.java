package org.example;

import no.uib.cipr.matrix.DenseMatrix;

public interface HypothesisFunction {


    public DenseMatrix compute(Dataset dataset, double[][] parameters);

}
