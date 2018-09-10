package ch.hslu.ad.sw05_N1.Aufgabe3;

import org.apache.logging.log4j.LogManager;

public class JoinAndSleep implements Runnable{
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(JoinAndSleep.class);

    private volatile boolean isStopped;
    private volatile Thread runThread;
    private Thread referenceThread;
    private long sleepTime;


    public JoinAndSleep(Thread referenceThread, long sleepTime, boolean isStopped) {
        this.referenceThread = referenceThread;
        this.sleepTime = sleepTime;
        this.isStopped = isStopped;
    }

    public void stopRequest(){
        if(referenceThread != null){
            referenceThread.interrupt();
        }
    }

    @Override
    public void run() {
        LOG.info("run started " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        try {
            if (isStopped){
                LOG.info("stop requested");
                stopRequest();
            }
            if (referenceThread != null) {
                LOG.info("waiting "+ Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                referenceThread.join();
                LOG.info("reference Thread joined "+ referenceThread.getName() + " " + referenceThread.getState());
            }
            LOG.info("sleeping: " + sleepTime);
            Thread.sleep(sleepTime);
            LOG.info("awake " + Thread.currentThread().getName() +" "+ Thread.currentThread().getState());
        } catch (InterruptedException e) {
            LOG.error("interrupted", e);
            //runThread.interrupt();
        }
    }
}
