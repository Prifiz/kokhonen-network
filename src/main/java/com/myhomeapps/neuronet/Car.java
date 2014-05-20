package com.myhomeapps.neuronet;

public class Car {
    private float length;
    private float width;
    private float height;
    private float maxVelocity;
    private float mass;
    private float turningRadius;
    private float roadClearance;
    private float base;
    private float fuelConsumption100km;
    private float timeTo100kmh;
    private float brakePath;
    private float engineVolume;

    public float getTimeTo100kmh() {
        return timeTo100kmh;
    }

    public void setTimeTo100kmh(float timeTo100kmh) {
        this.timeTo100kmh = timeTo100kmh;
    }

    public float getBrakePath() {
        return brakePath;
    }

    public void setBrakePath(float brakePath) {
        this.brakePath = brakePath;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(float maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getTurningRadius() {
        return turningRadius;
    }

    public void setTurningRadius(float turningRadius) {
        this.turningRadius = turningRadius;
    }

    public float getRoadClearance() {
        return roadClearance;
    }

    public void setRoadClearance(float roadClearance) {
        this.roadClearance = roadClearance;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    

    public float getFuelConsumption100km() {
        return fuelConsumption100km;
    }

    public void setFuelConsumption100km(float fuelConsumption100km) {
        this.fuelConsumption100km = fuelConsumption100km;
    }
    
    float[] toArray() {
        
        float[] result = new float[12];
        result[0] = base;
        result[1] = fuelConsumption100km;
        result[2] = height;
        result[3] = length;
        result[4] = mass;
        result[5] = maxVelocity;
        result[6] = roadClearance;
        result[7] = turningRadius;
        result[8] = width;
        result[9] = brakePath;
        result[10] = engineVolume;
        result[11] = timeTo100kmh;
        return result;
    }
}
