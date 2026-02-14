package station;

import observer.Observer;

public interface IWeatherStation {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
