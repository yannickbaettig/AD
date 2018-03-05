package ch.hslu.ad.sw01.memoryDemo;

public interface Memory {


    public Allocation malloc(int blockSize);

    public void free(Allocation block);

    public int getFree();

    public int getAllocated();
}
