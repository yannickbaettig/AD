package ch.hslu.ad.sw04_D3.Aufgabe5;

import ch.hslu.ad.sw04_D3.Allocation;

import java.lang.reflect.Array;

public class ArrayMaker {

        public static Allocation[] arrayWithSize(int size) {
            Allocation[] allocations = new Allocation[size];

            for (int i = 0; i <= allocations.length-1; i++){
                allocations[i] = new Allocation(1,1);
            }

            return allocations;
        }
}


