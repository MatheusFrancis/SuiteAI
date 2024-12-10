    package org.example;


    import java.io.FileNotFoundException;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        LinearRegression iniciar = new LinearRegression("/home/matheus/Downloads/PrasannaNatarajan-Coursera" +
                "-Machine-Learning-Andrew-NG-7c18e24/machine-learning-ex1/ex1/ex1data2.txt", 0.01, 1500);
        try {
            iniciar.preparation();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        iniciar.computeCostFunction();
        iniciar.computeGradientDescent();


    }
}