package ch.hslu.ad.sw04_D3;

import org.apache.logging.log4j.LogManager;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation>{
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Allocation.class);
    private final int size;
    private final int address;

    public Allocation(int size, int address) {
        this.size = size;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
      // LOG.info("equals method");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation that = (Allocation) o;
        return Objects.equals(size, that.size) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
//        LOG.info("hashCode method");
        return Objects.hash(address);
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
