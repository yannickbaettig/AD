package ch.hslu.ad.sw08_N3.Aufgabe2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private static final Logger LOG = LogManager.getLogger(Simulation.class);

    public static void main(final String[] args) throws InterruptedException {
        int totalCars = 400;
        int carsParked = 0;

        ExecutorService executor = Executors.newCachedThreadPool();
        List<CarPark> carParks = new ArrayList<>();

        carParks.add(new CarPark(20));
        carParks.add(new CarPark(30));
        carParks.add(new CarPark(40));


        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < (totalCars / 4); i++) {
            cars.add(new Car(carParks, Driver.FIRST));
            cars.add(new Car(carParks, Driver.ALL));
            cars.add(new Car(carParks, Driver.ALL_WAIT));
            cars.add(new Car(carParks, Driver.SPACE));

        }

        executor.invokeAll(cars);
/*        for (Car car: cars) {
            executor.submit(car);
        }

        executor.awaitTermination(5, TimeUnit.SECONDS);*/
        executor.shutdown();
        for (CarPark c: carParks) {
            LOG.info(c.getCapacity() + " " + c.getCarsParked() + " " + c.getTotalCarsParked());
            carsParked +=c.getTotalCarsParked();
        }
        LOG.info("Total Cars: " + totalCars);
        LOG.info("Cars Parked: " + carsParked);
        LOG.info("Cars Not Parked: " + (totalCars -carsParked));
    }
}
