package com.myhomeapps.neuronet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LearningSetGenerator generator = new LearningSetGenerator();
        List<Neuron> net = generator.initializeNet(2, 9);
//        float[] auto1 = {1, 2, 3};
//        float[] auto2 = {1.1f, 2.1f, 3.1f};
//        float[] auto3 = {0.9f, 1.9f, 2.9f};
//        float[] auto4 = {10, 20, 30};
//        float[] auto5 = {10.1f, 20.1f, 30.1f};
//        float[] auto6 = {9.9f, 19.9f, 29.9f};
//        List learningSet = new ArrayList();
//        learningSet.add(auto1);
//        learningSet.add(auto2);
//        learningSet.add(auto3);
//        learningSet.add(auto4);
//        learningSet.add(auto5);
//        learningSet.add(auto6);
        
        
        List learningSet = new ArrayList();
        CarParamsRanges passengerRange = generator.setPassengerCarParams();
        CarParamsRanges truckRange = generator.setTrucksParams();
        for(int i = 0; i < 20; i++) {
            learningSet.add(generator.getCarsLearningSet(truckRange));
        }
        
        for(Iterator it = learningSet.iterator(); it.hasNext();) {
            float[] auto = (float[]) it.next();
            //int winner = generator.getWinnerIndexWTA(net, auto);
            int winner = 0;
            net = generator.getTaughtNetWTA(net, winner, auto);
        }
        
        for(int i = 0; i < 20; i++) {
            learningSet.add(generator.getCarsLearningSet(passengerRange));
        }
        
        for(Iterator it = learningSet.iterator(); it.hasNext();) {
            float[] auto = (float[]) it.next();
            //int winner = generator.getWinnerIndexWTA(net, auto);
            int winner = 1;
            net = generator.getTaughtNetWTA(net, winner, auto);
        }
        
        Car testCar = new Car();
        testCar.setBase(120);
        testCar.setFuelConsumption100km(5);
        testCar.setHeight(100);
        testCar.setLength(200);
        testCar.setMass(1500);
        testCar.setMaxVelocity(250);
        testCar.setRoadClearance(15);
        testCar.setTurningRadius(170);
        testCar.setWidth(100);
        float[] testAuto = testCar.toArray();
        //float[] testAuto = generator.getCarsLearningSet(truckRange);
        int realWinner = generator.getWinnerIndexWTA(net, testAuto);
        System.out.println("REAL WINNER IS: " + realWinner);
        if(realWinner == 0) {
            System.out.println("Input car is TRUCK");
        } else if(realWinner == 1) {
            System.out.println("Input car is PASSENGER_CAR");
        }
        
    }
}
