package org.example;

public interface Optimizer {


    public void compute(Dataset dataset, CostFunction costFunction, double[][] parameters);


}
