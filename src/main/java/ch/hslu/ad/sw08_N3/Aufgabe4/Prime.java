package ch.hslu.ad.sw08_N3.Aufgabe4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Prime {
    private static final Logger LOG = LogManager.getLogger(Prime.class);

    public static void main(final String[] args) throws InterruptedException {
        LOG.info("start");
/*        int n = 1;
        try (FileWriter fileWriter = new FileWriter("/Users/yannickbattig/Projekte/HSLU Projects/ad_exercises/src/test/resources/test.txt")) {
            while (n <= 50) {
                BigInteger bi = new BigInteger(1024, new Random());
                if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                    LOG.info(n + ": " + bi.toString().substring(0, 20) + "...");
                    fileWriter.write(n + ": " + bi.toString().substring(0, 20) + "..." + System.lineSeparator());
                    n++;
                }
            }
        } catch (IOException e) {
            LOG.error("File not Found " + e);
        }

    }*/
        AtomicInteger counter = new AtomicInteger(0);
        AtomicInteger uslessNumbers = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<BigInteger>> futures = new ArrayList<>();
        while (counter.get() < 20) {
            futures.add(executor.submit(new PrimeTask(new BigInteger(1024, new Random()), counter, uslessNumbers)));
            //Thread.sleep(10);
        }

        List<BigInteger> filteredBigInteger = futures.stream().map(Prime::test).filter(Objects::nonNull).collect(Collectors.toList());

        executor.submit(new PrintTask(filteredBigInteger));

        LOG.info(filteredBigInteger.size());
        LOG.info(uslessNumbers);
        for (BigInteger bi: filteredBigInteger) {
            LOG.info(bi.toString().substring(0, 20) + "...");
        }
        executor.shutdown();
    }



    private static BigInteger test(Future<BigInteger> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }
}



