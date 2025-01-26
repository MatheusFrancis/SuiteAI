package org.example;

public interface Optimizer {


    public double[][] compute(Dataset dataset, CostFunction costFunction, double[][] parameters);


}
