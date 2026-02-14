package observer;

import station.IWeatherStation;

public class Observer implements IObserver {
    private String name;
    private IWeatherStation weatherStation;

    public Observer(String name, IWeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received an update. Temperature is: " + temperature + "°C");
    }

}
