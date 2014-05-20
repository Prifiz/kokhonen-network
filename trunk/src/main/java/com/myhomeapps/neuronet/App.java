package com.myhomeapps.neuronet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<Neuron> handleMainMenu() {
        System.out.println("Choose the educational algorithm:");
        boolean exit = false;
        List<Neuron> result = new ArrayList<Neuron>();
        while (!exit) {
            System.out.println("1. WTA");
            System.out.println("2. Kohonen");
            System.out.println("3. Exit");

            int inputValue;
            try {
                Scanner scanner = new Scanner(System.in);
                inputValue = scanner.nextInt();
                switch (inputValue) {
                    case 1: {
                        List<Neuron> net = Initializer.initializeNet(3, 12);
                        CarParamsRanges passengerRange = LearningSetGenerator.setPassengerCarParams();
                        List passengerCarLearningSet = LearningSetGenerator.generateLearningSets(20, passengerRange);
                        net = teachNetworkWTA(net, passengerCarLearningSet, 0);
                        CarParamsRanges truckRange = LearningSetGenerator.setTrucksParams();
                        List truckLearningSet = LearningSetGenerator.generateLearningSets(20, truckRange);
                        net = teachNetworkWTA(net, truckLearningSet, 1);
                        CarParamsRanges unrealCarRange = LearningSetGenerator.setUnrealCarsParams();
                        List unrealCarLearningSet = LearningSetGenerator.generateLearningSets(20, unrealCarRange);
                        net = teachNetworkWTA(net, unrealCarLearningSet, 2);
                        return net;
                    }
                    case 2: {
                        List<Neuron> net = Initializer.initializeNet(3, 12);
                        CarParamsRanges passengerRange = LearningSetGenerator.setPassengerCarParams();
                        List passengerCarLearningSet = LearningSetGenerator.generateLearningSets(20, passengerRange);
                        net = teachNetworkKohonen(net, passengerCarLearningSet, 0);
                        CarParamsRanges truckRange = LearningSetGenerator.setTrucksParams();
                        List truckLearningSet = LearningSetGenerator.generateLearningSets(20, truckRange);
                        net = teachNetworkKohonen(net, truckLearningSet, 1);
                        CarParamsRanges unrealCarRange = LearningSetGenerator.setUnrealCarsParams();
                        List unrealCarLearningSet = LearningSetGenerator.generateLearningSets(20, unrealCarRange);
                        net = teachNetworkKohonen(net, unrealCarLearningSet, 2);
                        return net;
                    }
                    case 3: {
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Incorrect input! Please, try again!");
                        break;
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("INPUT SHOULD BE NUMBER");
            }
        }
        return result;
    }

    public static List<Neuron> teachNetworkWTA(List<Neuron> net, List learningSet, int winner) {
        for (Iterator it = learningSet.iterator(); it.hasNext();) {
            float[] auto = (float[]) it.next();
            net = Teacher.getTaughtNetWTA(net, winner, auto);
        }
        return net;
    }

    public static List<Neuron> teachNetworkKohonen(List<Neuron> net, List learningSet, int winner) {
        for (Iterator it = learningSet.iterator(); it.hasNext();) {
            float[] auto = (float[]) it.next();
            net = Teacher.getTaughtNetKohonen(net, winner, auto);
        }
        return net;
    }

    public static int getTestWinner(List<Neuron> taughtNetwork) {
        System.out.println("Choose the test car type:");
        boolean exit = false;

        int result = -1;

        while (!exit) {
            System.out.println("1. Passenger Car");
            System.out.println("2. Truck");
            System.out.println("3. Unreal Car");

            int inputValue;
            try {
                Scanner scanner = new Scanner(System.in);
                inputValue = scanner.nextInt();
                switch (inputValue) {
                    case 1: {
                        CarParamsRanges passengerRange = LearningSetGenerator.setPassengerCarParams();
                        float[] testAuto = LearningSetGenerator.getCarsLearningSet(passengerRange);
                        return Teacher.getWinnerIndex(taughtNetwork, testAuto);
                    }
                    case 2: {
                        CarParamsRanges truckRange = LearningSetGenerator.setTrucksParams();
                        float[] testAuto = LearningSetGenerator.getCarsLearningSet(truckRange);
                        return Teacher.getWinnerIndex(taughtNetwork, testAuto);
                    }
                    case 3: {
                        CarParamsRanges unrealCar = LearningSetGenerator.setUnrealCarsParams();
                        float[] testAuto = LearningSetGenerator.getCarsLearningSet(unrealCar);
                        return Teacher.getWinnerIndex(taughtNetwork, testAuto);
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("INPUT SHOULD BE NUMBER");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean stop = false;
        while (!stop) {
            System.out.println("1. Continue working");
            System.out.println("2. Exit");

            switch ((new Scanner(System.in)).nextInt()) {
                case 1: {
                    List<Neuron> taughtNetwork = handleMainMenu();
                    int realWinner = getTestWinner(taughtNetwork);

                    if (realWinner == 0) {
                        System.out.println("Input car is PASSENGER_CAR");
                    } else if (realWinner == 1) {
                        System.out.println("Input car is TRUCK");
                    } else if (realWinner == 2) {
                        System.out.println("Input cat is UNREAL_CAR");
                    } else {
                        System.out.println("ERROR OCCURED");
                    }
                    break;
                }
                case 2: {
                    stop = true;
                    break;
                }
            }
        }
    }
}
