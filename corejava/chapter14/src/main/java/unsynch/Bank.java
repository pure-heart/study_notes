package unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther:JHLY
 * @Date:2019/10/13
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    //条件对象
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 使用锁对象保护
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount) {
        //加入锁防止线程并发影响
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();//线程放到条件的等待集中
                System.out.println(Thread.currentThread());
                accounts[from] -= amount;
                System.out.printf("%10.2f from %d to %d", amount, from, to);
                accounts[to] += amount;
                System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
                sufficientFunds.signalAll();//解除该条件的等待集中的所有线程的阻塞状态
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    /**等效于上面的transfer方法
     * 使用synchronized使对象的锁保护整个方法
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    public synchronized void transfer1(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();//线程放到条件的等待集中
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
            notifyAll();//解除该条件的等待集中的所有线程的阻塞状态
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
