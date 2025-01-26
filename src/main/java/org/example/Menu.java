package org.example;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Menu {

    private Scanner myScanner;
    Dataset trainSet;
    Dataset testSet;

    public Menu() {

        this.myScanner = new Scanner(System.in);

    }

    public void openDataset() throws FileNotFoundException {

        trainSet = new Dataset();
        trainSet.importFile("/home/matheus/housingTraining.txt");

        testSet = new Dataset();
        testSet.importFile("/home/matheus/housingTest.txt");


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


    public void applyModel() {

        LinearRegression regLin;
        System.out.println("Select the machine learning method: ");
        System.out.println("Type (1) for linear regression and (2) for another");

        int rep = myScanner.nextInt();
        if (rep == 1) {

            double[][] parameter = new double[trainSet.generateDesignMatrix()[0].length][1];

            System.out.println("Digite o valor inicial do parâmetro theta: ");
            for (int i = 0; i < trainSet.generateDesignMatrix()[0].length; i++) {

                System.out.println("Valor de theta " + i + " :" );
                parameter[i][0] = myScanner.nextDouble();

            }

            System.out.println("Deseja normalizar os atributos do seu conjunto de dados?");
            System.out.println("Digite (1) para normalizar (RECOMENDADO) e (0) para NÃO normalizar");

            rep = myScanner.nextInt();
            boolean normalize;
            if (rep == 1) normalize = true;
            else normalize = false;



            HypothesisFunction hypothesisFunction = new LinearHypothesis(normalize);
            CostFunction lossFunction = new MSE(hypothesisFunction);
            Optimizer gradientDescent = new GradientDescent(0.01, 400, normalize);

            regLin = new LinearRegression(lossFunction, gradientDescent);

            parameter = regLin.fit(trainSet, parameter);

            //predict values for the test set
            JMatrix example = new JMatrix();
            example.printMatrix(hypothesisFunction.compute(testSet, parameter));






        }


    }


}
