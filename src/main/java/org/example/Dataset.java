package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Dataset {

    private List<Instance> instances;


    public Dataset() {

        this.instances = new ArrayList<>();

    }

    public void importFile(String pathFile) throws FileNotFoundException {

        try {
            Scanner infile = new Scanner(new File(pathFile));
            int numOfRows = infile.nextInt();
            int numOfColumns = infile.nextInt();

            Instance sample;
            Feature feature, label;

            for (int i = 0; i < numOfRows; i++) {

                sample = new Instance();

                for (int j = 0; j < numOfColumns; j++) {

                    feature = new Feature(infile.nextDouble());
                    sample.addFeatures(feature);

                }

                label = new Feature(infile.nextDouble());
                sample.addLabel(label);
                this.instances.add(sample);

            }

            infile.close();

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não encontrado");

        }


    }


    public double[][] generateDesignMatrix() {

        double[][] designMatrix = new double[instances.size()][instances.getFirst().getFeatures().size() + 1];

        for (int i = 0; i < instances.size(); i++) {

            designMatrix[i][0] = 1.0;

            for (int j = 0; j < instances.getFirst().getFeatures().size(); j++)

                designMatrix[i][j + 1] = instances.get(i).getFeatures().get(j).getValue();


        }

        return designMatrix;

    }

    public double[][] generateDesignMatrixNormalized() {

        double[][] designMatrixNormalized = generateDesignMatrix();

        StatisticalMatrix stat = new StatisticalMatrix();
        double[] mu = stat.matrixMean(designMatrixNormalized);
        double[] sigma = stat.matrixStandardDeviation(designMatrixNormalized);


        for (int i = 0; i < designMatrixNormalized[0].length - 1; i++) {   //preserve the intercept column

            for (int j = 0; j < designMatrixNormalized.length; j++) {


                designMatrixNormalized[j][i + 1] -= mu[i];
                if (sigma[i] == 0) designMatrixNormalized[j][i + 1] = 0;   //avoid division by zero
                else designMatrixNormalized[j][i + 1] /= sigma[i];


            }
        }
        return designMatrixNormalized;
    }

    public double[][] generateFeaturesArray() {

        double[][] featuresArray = new double[instances.getFirst().getFeatures().size()][instances.size()];

        for (int i = 0; i < instances.size(); i++) {

            for (int j = 0; j < instances.getFirst().getFeatures().size(); j++) {

                featuresArray[i][j] = instances.get(i).getFeatures().get(j).getValue();


            }


        }

        return featuresArray;

    }

    public double[] generateLabelArray() {

        double[] labelArray = new double[instances.size()];

        for (int i = 0; i < instances.size(); i++) {

            labelArray[i] = instances.get(i).getLabel().getValue();
        }

        return labelArray;

    }


    public List<Instance> getInstances() {
        return instances;
    }

}


