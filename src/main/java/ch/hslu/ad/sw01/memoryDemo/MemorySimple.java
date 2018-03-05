package ch.hslu.ad.sw01.memoryDemo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MemorySimple implements Memory {
    private int size;
    private int allocated;
    private List<Allocation> occupied = new LinkedList<>();
    private List<Allocation> free = new LinkedList<>();


    public MemorySimple(int size) {
        this.size = size;
        this.allocated = 0;
    }


    @Override
    public Allocation malloc(int blockSize) {
        ListIterator<Allocation> listIterator = occupied.listIterator();
        int address;

        if (occupied.isEmpty()){
            address = 0;
        } else {
            Allocation allocation = occupied.get(occupied.size()-1);
            address = allocation.getAddress() + allocation.getSize();
        }
        Allocation newAllocation = new Allocation(blockSize, address);
        occupied.add(newAllocation);
        allocated += blockSize;
        return newAllocation;
    }

    @Override
    public void free(Allocation block) {
        free.add(block);
        occupied.remove(block);
        allocated -= block.getSize();
    }

    @Override
    public int getFree() {
        return size-allocated;
    }

    @Override
    public int getAllocated() {
        return allocated;
    }

    @Override
    public String toString() {
        return "MemorySimple{" +
                "size=" + size +
                ", allocated=" + allocated +
                '}';
    }
}
