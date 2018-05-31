package ch.hslu.ad.sw14_15_A5.Aufgabe5;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RailwayNet2Test {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(RailwayNet2Test.class);
    RailwayNet2 rn;


    @Before
    public void before(){
        rn = new RailwayNet2();
        rn.addStation("Rotkreuz");
        rn.addStation("Luzern");
        rn.addStation("Zug");
        rn.addStation("Zofingen");
        rn.addConnection("Rotkreuz","Luzern",16);
        rn.addConnection("Rotkreuz", "Zug", 12);
        rn.addConnection("Luzern","Zofingen",35);
    }

    @Test//(expected = IllegalArgumentException.class)
    public void removeStation() {
        rn.removeStation("Zofingen");
        //rn.addConnection("Rotkreuz", "Zofingen",10);
    }

    @Test
    public void removeConnection() {
        rn.removeConnection("Luzern","Zofingen");
        LOG.info(rn.directConnectionsFrom("Luzern"));
    }

    @Test
    public void numberOfStations() {
        assertEquals(4, rn.numberOfStations());
    }

    @Test
    public void numberOfConnections() {
        assertEquals(3, rn.numberOfConnections());
    }

    @Test
    public void isDirect() {
        assertEquals(true, rn.isDirect("Luzern","Zofingen"));
    }

    @Test
    public void isDirect2() {
        assertEquals(false, rn.isDirect("Rotkreuz","Zofingen"));
    }

    @Test
    public void directConnectionsFrom() {
        LOG.info(rn.directConnectionsFrom("Luzern"));
    }

    @Test
    public void travelTime() {
        assertEquals(35,rn.travelTime("Luzern", "Zofingen"));
    }
}