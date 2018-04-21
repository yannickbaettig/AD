package ch.hslu.ad.sw08_N3.Aufgabe2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;

public class Car implements Callable<Boolean> {
    private static final Logger LOG = LogManager.getLogger(Car.class);
    private List<CarPark> carParks;
    private int parkTime;
    private Driver driver;
    private CarParkComparator CarParkComparator = new CarParkComparator();

    public Car(List<CarPark> carParks, Driver driver) {
        this.carParks = carParks;
        this.parkTime = new Random().nextInt(10000) + 1000;
        this.driver = driver;
    }

/*    @Override
    public void run() {
        try {
        carParks.get(0).entrance(10,parkTime);
        carParks.get(1).entrance(parkTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public Boolean call() throws Exception {
        switch (driver) {
            case FIRST:
                carParks.get(0).entranceWaitForever(parkTime,driver);
                break;
            case ALL:
                for (CarPark cp: carParks) {
                    cp.entranceIfAvailable(parkTime, driver);
                }
                break;
            case ALL_WAIT:
                for (CarPark cp: carParks) {
                    cp.entrance(1000, parkTime, driver);
                }
                break;
            case SPACE:
                Optional<CarPark> carPark = carParks.stream().max(CarParkComparator);
                if(carPark.get().availablePermits() >= 0){
                    carPark.get().entranceIfAvailable(parkTime,driver);
                }
                break;
        }
        return true;
    }
}
