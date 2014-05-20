package com.myhomeapps.neuronet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LearningSetGenerator {
    
    public static CarParamsRanges setPassengerCarParams() {
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
        passengerCar.setBrakePath_min(5);
        passengerCar.setBrakePath_max(10);
        passengerCar.setEngineVolume_min(1);
        passengerCar.setEngineVolume_max(3);
        passengerCar.setTimeTo100kmh_min(4);
        passengerCar.setTimeTo100kmh_max(7);
        return passengerCar;
    }
    
    public static CarParamsRanges setTrucksParams() {
        CarParamsRanges truck = new CarParamsRanges();
        truck.setBase_min(200);
        truck.setBase_max(450);
        truck.setFuelConsumption100km_min(20);
        truck.setFuelConsumption100km_max(50);
        truck.setHeight_min(150);
        truck.setHeight_max(250);
        truck.setLength_min(400);
        truck.setLength_max(700);
        truck.setMass_min(3500);
        truck.setMass_max(10000);
        truck.setMaxVelocity_min(80);
        truck.setMaxVelocity_max(120);
        truck.setRoadClearance_min(25);
        truck.setRoadClearance_max(40);
        truck.setTurningRadius_min(300);
        truck.setTurningRadius_max(800);
        truck.setWidth_min(200);
        truck.setWidth_max(350);
        truck.setBrakePath_min(12);
        truck.setBrakePath_max(20);
        truck.setEngineVolume_min(5);
        truck.setEngineVolume_max(15);
        truck.setTimeTo100kmh_min(10);
        truck.setTimeTo100kmh_max(20);
        return truck;
    }
    
    public static CarParamsRanges setUnrealCarsParams() {
        CarParamsRanges sportCar = new CarParamsRanges();
        sportCar.setBase_min(10);
        sportCar.setBase_max(20);
        sportCar.setFuelConsumption100km_min(0.1f);
        sportCar.setFuelConsumption100km_max(0.5f);
        sportCar.setHeight_min(500);
        sportCar.setHeight_max(700);
        sportCar.setLength_min(5);
        sportCar.setLength_max(10);
        sportCar.setMass_min(10);
        sportCar.setMass_max(20);
        sportCar.setMaxVelocity_min(3500);
        sportCar.setMaxVelocity_max(5000);
        sportCar.setRoadClearance_min(50);
        sportCar.setRoadClearance_max(70);
        sportCar.setTurningRadius_min(5000);
        sportCar.setTurningRadius_max(7000);
        sportCar.setWidth_min(700);
        sportCar.setWidth_max(1000);
        sportCar.setBrakePath_min(1000);
        sportCar.setBrakePath_max(2000);
        sportCar.setEngineVolume_min(100);
        sportCar.setEngineVolume_max(200);
        sportCar.setTimeTo100kmh_min(0.5f);
        sportCar.setTimeTo100kmh_max(1);
        return sportCar;
    }
    
    public static float[] getCarsLearningSet(CarParamsRanges range) {
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
        car.setBrakePath(
                range.getBrakePath_min() +
                rand.nextFloat() * (range.getBrakePath_max() - range.getBrakePath_min()));
        car.setEngineVolume(
                range.getEngineVolume_min() +
                rand.nextFloat() * (range.getEngineVolume_max() - range.getEngineVolume_min()));
        car.setTimeTo100kmh(
                range.getTimeTo100kmh_min() +
                rand.nextFloat() * (range.getTimeTo100kmh_max() - range.getTimeTo100kmh_min()));
        return car.toArray();
    }
    
    public static List generateLearningSets(int setSize, CarParamsRanges range) {
        List result = new ArrayList();
        for(int i = 0; i < setSize; i++) {
            result.add(getCarsLearningSet(range));
        }
        return result;
    }
}
