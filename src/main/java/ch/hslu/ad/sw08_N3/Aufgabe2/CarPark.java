package ch.hslu.ad.sw08_N3.Aufgabe2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarPark {
    private static final Logger LOG = LogManager.getLogger(CarPark.class);
    private int totalCarsParked;

    private Semaphore capacity;
    private Semaphore carsParked;

    public CarPark(int capacity) {
        this.capacity = new Semaphore(capacity);
        this.carsParked = new Semaphore(0);
        this.totalCarsParked = 0;
    }


    public void entrance(int timeToWait,int parkTime, Driver driver) throws InterruptedException {
        boolean entered = capacity.tryAcquire(timeToWait,TimeUnit.MILLISECONDS);
        if (entered){
            LOG.info("parking space acquired by " + driver);
            totalCarsParked++;
            carsParked.release();
            Thread.sleep(parkTime);
            exit(driver);
        }

    }

    public void entranceWaitForever(int parkTime, Driver driver) throws InterruptedException {
        capacity.acquire();
            LOG.info("parking space acquired by " + driver);
            totalCarsParked++;
            carsParked.release();
            Thread.sleep(parkTime);
            exit(driver);
    }

    public void entranceIfAvailable(int parkTime, Driver driver) throws InterruptedException {
        boolean entered = capacity.tryAcquire();
        if (entered) {
            LOG.info("parking space acquired by " + driver);
            totalCarsParked++;
            carsParked.release();
            Thread.sleep(parkTime);
            exit(driver);
        }
    }


    public void exit(Driver driver) throws InterruptedException {
        carsParked.acquire();
        LOG.info("parking space released by " + driver);
        capacity.release();
        this.notifyAll();
    }


    public int getTotalCarsParked() {
        return totalCarsParked;
    }

    public Semaphore getCapacity() {
        return capacity;
    }

    public Semaphore getCarsParked() {
        return carsParked;
    }

    public int availablePermits(){
        return this.getCapacity().availablePermits();
    }

}
