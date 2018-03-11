package ch.hslu.ad.sw01_E1.memoryDemo;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation>{
    private final int size;
    private final int address;

    public Allocation(int size, int address) {
        this.size = size;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation that = (Allocation) o;
        return Objects.equals(size, that.size) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, address);
    }

    @Override
    public int compareTo(Allocation o) {
        return Integer.compare(this.address, o.address);
    }


    @Override
    public String toString() {
        return "Allocation{" +
                "size=" + size +
                ", address=" + address +
                '}';
    }

    public int getSize() {
        return size;
    }

    public int getAddress() {
        return address;
    }
}
