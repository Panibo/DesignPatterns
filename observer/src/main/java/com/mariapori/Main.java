package com.mariapori;

import com.mariapori.observer.Observer;
import com.mariapori.station.WeatherStation;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread stationThread = new Thread(weatherStation);
        stationThread.start();

        Observer observer1 = new Observer("Observer 1", weatherStation);
        Observer observer2 = new Observer("Observer 2", weatherStation);
        Observer observer3 = new Observer("Observer 3", weatherStation);

        // Wait for a while before removing observer 1
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nRemoving Observer 1\n");
        weatherStation.removeObserver(observer1);

        // Wait for a while before interrupting the station thread
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stationThread.interrupt();
    }
}