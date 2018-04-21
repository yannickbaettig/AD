package ch.hslu.ad.sw08_N3.Aufgabe2;

import java.util.Comparator;

public class CarParkComparator implements Comparator<CarPark> {
    @Override
    public int compare(CarPark o1, CarPark o2) {
        return o1.getCapacity().availablePermits() - o2.getCapacity().availablePermits();
    }
}
