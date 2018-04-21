package ch.hslu.ad.sw08_N3.Aufgabe4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

public class PrintTask implements Runnable {
    private static final Logger LOG = LogManager.getLogger(Prime.class);
    private List<BigInteger> bigIntegers;

    public PrintTask(List<BigInteger> filteredBigInteger) {
        this.bigIntegers = filteredBigInteger;
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter("/Users/yannickbattig/Projekte/HSLU Projects/ad_exercises/src/test/resources/test.txt")) {
            for (BigInteger bi : bigIntegers) {
                fileWriter.write(bi.toString().substring(0, 20) + "..." + System.lineSeparator());
            }
        } catch (IOException e){
            LOG.error("File not Found " + e);
        }

    }
}
