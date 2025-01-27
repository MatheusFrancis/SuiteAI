package org.example;

public abstract class Model {

    protected HypothesisFunction hypothesisFunction;
    protected Optimizer optimizer;

    public Model(HypothesisFunction hypothesisFunction, Optimizer optimizer) {

        this.hypothesisFunction = hypothesisFunction;
        this.optimizer = optimizer;

    }


    public double[][] fit(Dataset data, double[][] parameters) {

        return optimizer.compute(data, hypothesisFunction, parameters);

    }


}
