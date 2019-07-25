package concurrency.lc1117_building_h2o;

import java.util.concurrent.Semaphore;

class H2O {

    private final Semaphore semH, semO;

    public H2O() {
        semH = new Semaphore(2);
        semO = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semO.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        semH.release(2);
    }
}
