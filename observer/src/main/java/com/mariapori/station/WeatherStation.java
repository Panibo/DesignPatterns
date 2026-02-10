package com.mariapori.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.mariapori.observer.Observer;

public class WeatherStation implements IWeatherStation, Runnable {
    private int temperature;
    private List<Observer> observers;

    public WeatherStation() {
        this.temperature = new Random().nextInt(50);
        this.observers = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            // Random temperature change
            int change = random.nextBoolean() ? 1 : -1;
            temperature += change;

            // Notify observers
            notifyObservers();

            // Sleep for a random time between 1 and 5 seconds
            try {
                Thread.sleep(1 + random.nextInt(5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        synchronized (observers) {
            // Notify all observers
            for (Observer observer : observers) {
                observer.update(temperature);
            }
        }
    }

}
