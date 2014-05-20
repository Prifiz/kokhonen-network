package com.myhomeapps.neuronet;

public class Normalizer {
    
    public float[] getNormalizedInput(float[] x, int components) {
        float[] result = new float[components];
        float length = getVectorLength(x, components);
        for (int i = 0; i < components; i++) {
            result[i] = x[i] / length;
        }
        return result;
    }
    
    float getVectorLength(float[] vector, int components) {
        float sum = 0;
        for (int i = 0; i < components; i++) {
            sum += vector[i] * vector[i];
        }
        return (float) Math.sqrt(sum);
    }
}
