package org.example;
import java.util.List;
import java.util.ArrayList;

public class Instance {

    private List<Feature> features;
    private Feature label;

    public Instance() {

        this.features = new ArrayList<>();

    }

    public void addFeatures(Feature feature) {

        features.add(feature);


    }


    public void addLabel(Feature label) {

        this.label = label;

    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Feature getLabel() {
        return label;
    }

}

