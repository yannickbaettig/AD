package ch.hslu.ad.sw14_15_A5.Aufgabe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RailwayNet1 {
    private List<String> stations;
    private List<List<Integer>> adjaMax;
    private static final int DEFAULT = -1; //No Connection


    public RailwayNet1() {
        this.stations = new ArrayList<>();
        this.adjaMax = new ArrayList<>();
    }

    public void addStation(String station) {
        stations.add(station);
        adjaMax.add(new ArrayList<>(Collections.nCopies(stations.size(),DEFAULT)));
        adjaMax.forEach((List<Integer> list) -> list.add(DEFAULT));

    }

    public void removeStation(String station) {
        int index = stations.indexOf(station);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid Station");
        }
        stations.remove(index);

        adjaMax.remove(index);
        for (List l : adjaMax){
            l.remove(index);
        }
    }

    public void addConnection(String from, String to, int travelTime) {
        int indexFrom = stations.indexOf(from);
        int indexTo = stations.indexOf(to);
        if (indexFrom == -1 || indexTo == -1){
            throw new IllegalArgumentException("Invalid Station");
        }
        adjaMax.get(indexFrom).set(indexTo,travelTime);
        adjaMax.get(indexTo).set(indexFrom,travelTime);
    }

    public void removeConnection(String from, String to) {
        int indexFrom = stations.indexOf(from);
        int indexTo = stations.indexOf(to);
        if (indexFrom == -1 || indexTo == -1){
            throw new IllegalArgumentException("Invalid Station");
        }
        adjaMax.get(indexFrom).set(indexTo,DEFAULT);
        adjaMax.get(indexTo).set(indexFrom,DEFAULT);

    }

    public int numberOfStations() {
        return stations.size();
    }

    public int numberOfConnections() {
        int counti = 0;

        for (List<Integer> list : adjaMax) {
            for (int i : list){
                if (i != DEFAULT) {
                    counti++;
                }
            }
        }
        return counti;
    }

    public boolean isDirect(String from, String to) {
        return travelTime(from,to) != DEFAULT; //|| travelTime(to,from) != DEFAULT;
    }

    public List<String> directConnectionsFrom(String station) {
        List<String> directConnectionsTo = new ArrayList<>();
        int index = stations.indexOf(station);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid Station");
        }
        List<Integer> st = adjaMax.get(index);
        for (Integer connection : st){
            if (connection != DEFAULT){
                int indexTo = st.indexOf(connection);
                directConnectionsTo.add(stations.get(indexTo));
            }
        }
        return directConnectionsTo;
    }

    public int travelTime(String from, String to){
        int indexFrom = stations.indexOf(from);
        int indexTo = stations.indexOf(to);
        if (indexFrom == -1 || indexTo == -1){
            throw new IllegalArgumentException("Invalid Station");
        }
        int travelTime = adjaMax.get(indexFrom).get(indexTo);
        return travelTime;
    }


}
