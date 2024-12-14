package org.example;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Menu {

    private Scanner myScanner;
    Dataset myDataset;

    public Menu() {

        this.myScanner = new Scanner(System.in);

    }

    public void openDataset() throws FileNotFoundException {

        myDataset = new Dataset();
        myDataset.importFile("/home/matheus/Downloads/PrasannaNatarajan-Coursera" +
                "-Machine-Learning-Andrew-NG-7c18e24/machine-learning-ex1/ex1/ex1data2.txt");

    }


    public void plotDataset() {

        Plotter myPlot = new Plotter();

        System.out.println("Que tipo de gráfico desejar plotar os seus dados? ");
        System.out.println("Digite (1) para scatter plot e (2) para outros plots: ");

        int rep = myScanner.nextInt();

        if (rep == 1) {

            myPlot.ScatterPlot(myDataset.generateColumnArray(0), myDataset.generateLabelArray());

            myPlot.setSize(800, 600);
            myPlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myPlot.setVisible(true);

        }

    }

    public void applyModel() {

        System.out.println("Select the machine learning method: ");
        System.out.println("Type (1) for linear regression and (2) for another");

        int rep = myScanner.nextInt();
        if (rep == 1) {

            LinearRegression regLin = new LinearRegression(myDataset, 0.01, 1500);
            regLin.computeCostFunction();
            regLin.computeGradientDescent();


        }





    }

}
