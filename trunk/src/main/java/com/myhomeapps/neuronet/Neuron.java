/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.neuronet;

/**
 *
 * @author Prifiz
 */
public class Neuron {
    private float[] weights;
    private int components;

    public float[] getWeights() {
        return weights;
    }

    public void setWeights(float[] weights) {
        this.weights = weights;
    }

    public int getComponents() {
        return components;
    }

    public void setComponents(int components) {
        this.components = components;
    }
}
