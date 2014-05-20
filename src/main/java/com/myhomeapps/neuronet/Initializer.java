package com.myhomeapps.neuronet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Prifiz
 * Date: 20.05.14
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
public class Initializer {

    public static List<Neuron> initializeNet(int neuronsCount, int components) {
        List<Neuron> result = new ArrayList<Neuron>();
        for(int i = 0; i < neuronsCount; i++) {
            Neuron neuron = new Neuron();
            neuron.setComponents(components);
            neuron.setWeights(generateWeights(components));
            result.add(neuron);
        }
        return result;
    }
    
    public static float[] generateWeights(int components) {
        float[] weights = new float[components];
        Random rand = new Random();
        for (int i = 0; i < weights.length; i++) {
            float w = rand.nextFloat();
            weights[i] = w;
        }
        return weights;
    }
}
