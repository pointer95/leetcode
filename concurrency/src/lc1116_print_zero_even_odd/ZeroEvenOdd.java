package lc1116_print_zero_even_odd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private final Semaphore semZero, semEven, semOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        semZero = new Semaphore(1);
        semEven = new Semaphore(0);
        semOdd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semEven.release();
            } else {
                semOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            semEven.acquire();
            printNumber.accept(i);
            semZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            semOdd.acquire();
            printNumber.accept(i);
            semZero.release();
        }
    }
}