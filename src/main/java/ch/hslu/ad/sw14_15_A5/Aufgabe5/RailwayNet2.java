package ch.hslu.ad.sw14_15_A5.Aufgabe5;

import java.util.*;

public class RailwayNet2 {
    private Map<String,Node> stations;

    private class Node {
        Map<String,Integer> edges = new HashMap<>();

        @Override
        public String toString() {
            return edges.toString();
        }
    }

    public RailwayNet2() {
        stations = new HashMap<>();
    }

    public void addStation(String station) {
        stations.put(station, new Node());
    }

    public void removeStation(String station) {
        stations.remove(station);
    }

    public void addConnection(String from, String to, int travelTime) {
        if (!stations.containsKey(to)){
            throw new IllegalArgumentException("Invalid Station");
        }
        stations.get(from).edges.put(to, travelTime);
    }

    public void removeConnection(String from, String to) {
        stations.get(from).edges.remove(to);
    }

    public int numberOfStations() {
        return stations.size();
    }

    public int numberOfConnections() {
        int counti = 0;
        for (String station : stations.keySet()) {
           counti += stations.get(station).edges.size();
        }
        return counti;
    }

    public boolean isDirect(String from, String to) {
        return stations.get(from).edges.containsKey(to);
    }

    public String directConnectionsFrom(String station) {
        return stations.get(station).toString();
    }

    public int travelTime(String from, String to){
        return stations.get(from).edges.get(to);
    }


}
