/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.neuronet;

/**
 *
 * @author baranov
 */
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
        
        float[] result = new float[9];
        result[0] = base;
        result[1] = fuelConsumption100km;
        result[2] = height;
        result[3] = length;
        result[4] = mass;
        result[5] = maxVelocity;
        result[6] = roadClearance;
        result[7] = turningRadius;
        result[8] = width;
        return result;
    }
}
