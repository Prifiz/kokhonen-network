package com.myhomeapps.neuronet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LearningSetGenerator {

    float getVectorLength(float[] vector, int components) {
        float sum = 0;
        for (int i = 0; i < components; i++) {
            sum += vector[i] * vector[i];
        }
        return (float) Math.sqrt(sum);
    }
    
    public List<Neuron> initializeNet(int neuronsCount, int components) {
        List<Neuron> result = new ArrayList<Neuron>();
        for(int i = 0; i < neuronsCount; i++) {
            Neuron neuron = new Neuron();
            neuron.setComponents(components);
            neuron.setWeights(generateWeights(components));
            result.add(neuron);
        }
        return result;
    }
    
    public List<Neuron> getTaughtNetWTA(List<Neuron> net, int winnerIndex, float[] input) {        
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

    public int[] getSArray(int K, int neuronsInNet, int winnerIndex) {
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

    public List<Neuron> getTaughtNetKohonen(List<Neuron> net, int winnerIndex, float[] input) {
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
    
    public int getWinnerIndexWTA(List<Neuron> net, float[] input) {
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

    public float[] getNormalizedInput(float[] x, int components) {
        float[] result = new float[components];
        float length = getVectorLength(x, components);
        for (int i = 0; i < components; i++) {
            result[i] = x[i] / length;
        }
        return result;
    }

    public float[] generateWeights(int components) {
        float[] weights = new float[components];
        Random rand = new Random();
        for (int i = 0; i < weights.length; i++) {
            float w = rand.nextFloat();
            weights[i] = w;
        }
        return weights;
    }

    public float getDistEuclid(float[] x, float[] w_i, int components) {
        float sum = 0;
        for (int j = 0; j < components; j++) {
            sum += (x[j] - w_i[j]) * (x[j] - w_i[j]);
        }
        return (float) Math.sqrt(sum);
    }
    
    public CarParamsRanges setPassengerCarParams() {
        CarParamsRanges passengerCar = new CarParamsRanges();
        
        passengerCar.setBase_min(100);
        passengerCar.setBase_max(150);
        passengerCar.setFuelConsumption100km_min(2);
        passengerCar.setFuelConsumption100km_max(12);
        passengerCar.setHeight_min(90);
        passengerCar.setHeight_max(120);
        passengerCar.setLength_min(150);
        passengerCar.setLength_max(400);
        passengerCar.setMass_min(900);
        passengerCar.setMass_max(3500);
        passengerCar.setMaxVelocity_min(150);
        passengerCar.setMaxVelocity_max(300);
        passengerCar.setRoadClearance_min(10);
        passengerCar.setRoadClearance_max(20);
        passengerCar.setTurningRadius_min(150);
        passengerCar.setTurningRadius_max(200);
        passengerCar.setWidth_min(80);
        passengerCar.setWidth_max(150);
        return passengerCar;
    }
    
    public CarParamsRanges setTrucksParams() {
        CarParamsRanges passengerCar = new CarParamsRanges();
        passengerCar.setBase_min(200);
        passengerCar.setBase_max(450);
        passengerCar.setFuelConsumption100km_min(20);
        passengerCar.setFuelConsumption100km_max(50);
        passengerCar.setHeight_min(150);
        passengerCar.setHeight_max(250);
        passengerCar.setLength_min(400);
        passengerCar.setLength_max(700);
        passengerCar.setMass_min(3500);
        passengerCar.setMass_max(10000);
        passengerCar.setMaxVelocity_min(80);
        passengerCar.setMaxVelocity_max(120);
        passengerCar.setRoadClearance_min(25);
        passengerCar.setRoadClearance_max(40);
        passengerCar.setTurningRadius_min(300);
        passengerCar.setTurningRadius_max(800);
        passengerCar.setWidth_min(200);
        passengerCar.setWidth_max(350);
        return passengerCar;
    }
    
    public float[] getCarsLearningSet(CarParamsRanges range) {
        Random rand = new Random();
        Car car = new Car();
        car.setBase(
                range.getBase_min() + 
                rand.nextFloat() * (range.getBase_max() - range.getBase_min()));
        car.setFuelConsumption100km(
                range.getFuelConsumption100km_min()+ 
                rand.nextFloat() * (range.getFuelConsumption100km_max() - range.getFuelConsumption100km_min()));
        car.setHeight(
                range.getHeight_min() + 
                rand.nextFloat() * (range.getHeight_max() - range.getHeight_min()));
        car.setLength(
                range.getLength_min() +
                rand.nextFloat() * (range.getLength_max() - range.getLength_min()));
        car.setMass(
                range.getMass_min() + 
                rand.nextFloat() * (range.getMass_max() - range.getMass_min()));
        car.setMaxVelocity(
                range.getMaxVelocity_min() + 
                rand.nextFloat() * (range.getMaxVelocity_max() - range.getMaxVelocity_min()));
        car.setRoadClearance(
                range.getRoadClearance_min() +
                rand.nextFloat() * (range.getRoadClearance_max() - range.getRoadClearance_min()));
        car.setTurningRadius(
                range.getTurningRadius_min() +
                rand.nextFloat() * (range.getTurningRadius_max() - range.getTurningRadius_min()));
        car.setWidth(
                range.getWidth_min() + 
                rand.nextFloat() * (range.getWidth_max() - range.getWidth_min()));
        return car.toArray();
    }
    
    
}
