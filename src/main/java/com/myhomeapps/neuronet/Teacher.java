package com.myhomeapps.neuronet;

import java.util.List;

public class Teacher {
    
    public static int[] getSArray(int K, int neuronsInNet, int winnerIndex) {
        int[] result = new int[neuronsInNet];
        for(int i = 0; i < neuronsInNet; i++) {
            if(Math.abs(winnerIndex - i) < K) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
    
    public static List<Neuron> getTaughtNetWTA(List<Neuron> net, int winnerIndex, float[] input) {        
        Neuron neuronToTeach = net.get(winnerIndex);
        float beta = 0.5f;
        float[] weightsOld = neuronToTeach.getWeights();
        int components = neuronToTeach.getComponents();
        float[] weightsNew = new float[components];
        for(int i = 0; i < components; i++) {
            weightsNew[i] = weightsOld[i] + beta * (input[i] - weightsOld[i]);
        }
        neuronToTeach.setWeights(weightsNew);
        net.set(winnerIndex, neuronToTeach);
        return net;
    }
    
    public static List<Neuron> getTaughtNetKohonen(List<Neuron> net, int winnerIndex, float[] input) {
        Neuron neuronToTeach = net.get(winnerIndex);
        float beta = 0.5f;
        float[] weightsOld = neuronToTeach.getWeights();
        int components = neuronToTeach.getComponents();
        float[] weightsNew = new float[components];
        int[] s = getSArray(1, net.size(), winnerIndex);
        for(int j = 0; j < net.size(); j++) {
            for(int i = 0; i < components; i++) {
                weightsNew[i] = weightsOld[i] + beta * s[j] * (input[i] - weightsOld[i]);
            }
        }
        neuronToTeach.setWeights(weightsNew);
        net.set(winnerIndex, neuronToTeach);
        return net;
    }
    
    public static int getWinnerIndex(List<Neuron> net, float[] input) {
        float minDist = (float) Double.POSITIVE_INFINITY;
        int winnerIndex = 0;
        for(int i = 0; i < net.size(); i++) {
            Neuron neuron = net.get(i);
            float[] w = neuron.getWeights();
            int components = neuron.getComponents();
            float currentDist = getDistEuclid(input, w, components);
            if(currentDist < minDist) {
                minDist = currentDist;
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
    
    public static float getDistEuclid(float[] x, float[] w_i, int components) {
        float sum = 0;
        for (int j = 0; j < components; j++) {
            sum += (x[j] - w_i[j]) * (x[j] - w_i[j]);
        }
        return (float) Math.sqrt(sum);
    }
}
