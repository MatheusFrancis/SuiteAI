package org.example;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Menu {

    private Scanner myScanner;
    Dataset trainSet;
    Dataset testSet;
    private int model;
    private String parameter;

    public Menu() {

        this.myScanner = new Scanner(System.in);

    }

    public void openDataset() throws FileNotFoundException {

        trainSet = new Dataset();
        trainSet.importFile("/home/matheus/housingTraining.txt");

        testSet = new Dataset();
        testSet.importFile("/home/matheus/housingTest.txt");


    }

    public void openTrainDataset(String path) throws FileNotFoundException {
        trainSet = new Dataset();
        trainSet.importFile(path);
    }

    public void openTestDataset(String path) throws FileNotFoundException {
        testSet = new Dataset();
        testSet.importFile(path);
    }

    public void plotDataset() {

        Plotter myPlot = new Plotter();

        System.out.println("Que tipo de gráfico desejar plotar os seus dados? ");
        System.out.println("Digite (1) para scatter plot e (2) para outros plots: ");

        int rep = myScanner.nextInt();

        if (rep == 1) {

            myPlot.ScatterPlot(trainSet.generateFeaturesArray(), trainSet.generateLabelArray());

            myPlot.setSize(800, 600);
            myPlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myPlot.setVisible(true);

        }

    }

    public void setModel(int selectedModel) {
        this.model = selectedModel;
    }

    public int getModel() {
        return this.model;
    }

    public void setParameter(String newParameter) {
        this.parameter = newParameter;
    }

    public String getParameter() {
        return this.parameter;
    }

    public void applyModel() {

        Model myModel;
        HypothesisFunction hypothesisFunction;
        CostFunction lossFunction;
        Optimizer gradientDescent;

        double[][] parameter = new double[trainSet.generateDesignMatrix()[0].length][1];

        System.out.println("Select the machine learning method: ");
        System.out.println("Type (1) for linear regression and (2) for logistic regression: ");

        int rep = myScanner.nextInt();

        System.out.println("Digite o valor inicial do parâmetro theta: ");
        for (int i = 0; i < trainSet.generateDesignMatrix()[0].length; i++) {

            System.out.println("Valor de theta " + i + " :" );
            parameter[i][0] = myScanner.nextDouble();

        }

        System.out.println("Deseja normalizar os atributos do seu conjunto de dados?");
        System.out.println("Digite (1) para normalizar (RECOMENDADO) e (0) para NÃO normalizar");

        int rep2 = myScanner.nextInt();
        boolean normalize;
        if (rep2 == 1) normalize = true;
        else normalize = false;

        if (rep == 1) {


            hypothesisFunction = new LinearHypothesis(normalize);
            lossFunction = new MSE(hypothesisFunction);
            gradientDescent = new GradientDescent(0.01, 400, normalize);

            myModel = new LinearRegression(lossFunction, gradientDescent);

            parameter = myModel.fit(trainSet, parameter);

            //predict values for the test set
            JMatrix example = new JMatrix();
            example.printMatrix(hypothesisFunction.compute(testSet, parameter));






        }

        else {

            hypothesisFunction =  new Sigmoid(normalize);
            lossFunction = new CrossEntropy(hypothesisFunction, normalize);
            gradientDescent = new GradientDescent(0.01, 400, normalize);

            myModel = new LogisticRegression(lossFunction, gradientDescent);



        }


    }



}
