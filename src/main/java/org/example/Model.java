package org.example;

public abstract class Model {

    protected CostFunction costFunction;
    protected Optimizer optimizer;

    public Model(CostFunction costFunction, Optimizer optimizer) {

        this.costFunction = costFunction;
        this.optimizer = optimizer;

    }


    public double[][] fit(Dataset data, double[][] parameters) {

        return optimizer.compute(data, costFunction, parameters);

    }


}
