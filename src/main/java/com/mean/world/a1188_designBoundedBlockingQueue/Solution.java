package com.mean.world.a1188_designBoundedBlockingQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tent on 2020-06-24 13:44
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {

        //mock();


        //example1();
        example2();

        //queue3_mock();
    }


    /**
     * Refer README.md's Example 1
     */
    public static void example1() throws InterruptedException {
        //final Queue1<Integer> queue = new Queue1(2);
        //final Queue2<Integer> queue = new Queue2(2);
        //final Queue3<Integer> queue = new Queue3(2);
        final Queue4 queue = new Queue4(2);

        final ExecutorService producer = Executors.newSingleThreadExecutor();
        final ExecutorService consumer = Executors.newSingleThreadExecutor();

        producer.submit(() -> {
            try {
                queue.enqueue(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.submit(() -> queue.dequeue());
        consumer.submit(() -> queue.dequeue());
        producer.submit(() -> {
            try {
                queue.enqueue(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.submit(() -> {
            try {
                queue.enqueue(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.submit(() -> {
            try {
                queue.enqueue(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.submit(() -> {
            try {
                queue.enqueue(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.submit(() -> queue.dequeue());
        System.out.println(queue.size());

        //producer.shutdown();
        //consumer.shutdown();
        //Thread.currentThread().join();
    }

    /**
     * Refer README.md's Example 2
     */
    public static void example2() {
        //final Queue1<Integer> queue = new Queue1(3);
        //final Queue2<Integer> queue = new Queue2(3);
        //final Queue3<Integer> queue = new Queue3(3);
        final Queue4 queue = new Queue4(3);

        final ExecutorService p1 = Executors.newSingleThreadExecutor();
        final ExecutorService p2 = Executors.newSingleThreadExecutor();
        final ExecutorService p3 = Executors.newSingleThreadExecutor();
        //final ExecutorService p4 = Executors.newSingleThreadExecutor();
        final ExecutorService c1 = Executors.newSingleThreadExecutor();
        final ExecutorService c2 = Executors.newSingleThreadExecutor();
        final ExecutorService c3 = Executors.newSingleThreadExecutor();
        final ExecutorService c4 = Executors.newSingleThreadExecutor();

        p1.submit(() -> {
            try {
                queue.enqueue(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });   // Producer thread P1 enqueues 1 to the queue.
        p2.submit(() -> {
            try {
                queue.enqueue(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });   // Producer thread P2 enqueues 0 to the queue.
        p3.submit(() -> {
            try {
                queue.enqueue(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });   // Producer thread P3 enqueues 2 to the queue.
        //p4.submit(() -> {
        //    try {
        //        queue.enqueue(20);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //});
        c1.submit(() -> queue.dequeue());    // Consumer thread C1 calls dequeue.
        c2.submit(() -> queue.dequeue());    // Consumer thread C2 calls dequeue.
        c3.submit(() -> queue.dequeue());    // Consumer thread C3 calls dequeue.
        p2.submit(() -> {
            try {
                queue.enqueue(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });   // One of the producer threads enqueues 3 to the queue.
        System.out.println(queue.size());

    }

    private static void queue3_mock() {
        final Queue3<Double> queue = new Queue3<>(2);
        final Runnable e = () -> {
            try {
                queue.enqueue(Math.random());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        };
        final Runnable d = () -> {
            try {
                Double num = queue.dequeue();
                System.out.println(num);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };
        new Thread(e, "p1").start();
        new Thread(d, "c1").start();
        new Thread(d, "c2").start();
        new Thread(d, "c3").start();

        new Thread(e, "p2").start();
    }

    /**
     * This part of code,
     * that simulate multiple producer threads and multiple consumer threads
     * operate the queue at same time.
     */
    public static void mock() throws InterruptedException {
        final Queue1<Double> queue = new Queue1(10);

        for (int i = 0; i < 3; i++) {
            final Thread producer = new Thread(() -> {
                try {
                    final double random = Math.random();
                    queue.enqueue(random);
                    System.out.println(String.format("Thread:[%s] produce:[%s]", Thread.currentThread().getName(), random));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            producer.start();
        }

        for (int i = 0; i < 5; i++) {
            final Thread consumer = new Thread(() -> {
                try {
                    final Double obj = queue.dequeue();
                    System.out.println(String.format("Thread:[%s] consume:[%s]", Thread.currentThread().getName(), obj));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            consumer.start();
        }
        Thread.currentThread().join();
    }
}


/**
 * Built_In_Queue
 * <p>
 * NOTICE:
 * ArrayBlockingQueue's put and take method will block,when queue is full for empty.
 */
class Queue1<T> {
    private ArrayBlockingQueue container;
    private int capacity;

    public Queue1(int capacity) {
        this.container = new ArrayBlockingQueue(capacity);
        this.capacity = capacity;
    }

    public boolean enqueue(T obj) throws InterruptedException {
        container.put(obj);
        return true;
    }

    public <T> T dequeue() throws InterruptedException {
        return (T) container.take();
    }

    public int size() {
        return container.size();
    }

}

/**
 * using synchronized
 * performance bad
 * at the same time, only one thread can use same method(enqueue/dequeue),lower concurrency.
 */
class Queue2<T> {
    private Queue<T> container;
    private int capacity;

    public Queue2(int capacity) {
        this.container = new ArrayDeque<>();
        this.capacity = capacity;
    }

    public void enqueue(T obj) throws InterruptedException {
        synchronized (container) {
            while (container.size() == capacity) {
                container.wait();
            }
            container.add(obj);
            container.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (container) {
            while (container.size() == 0) {// 用while防止虚假唤醒
                container.wait();
            }
            final T element = container.remove();
            container.notifyAll();
            return element;
        }
    }

    public int size() {
        return container.size();
    }
}

/**
 * NOTICE:
 * Semaphore can controls the number of threads what access the resource at same time.
 */
class Queue3<T> {
    private Semaphore e, d;
    private Queue<T> container;

    public Queue3(int capacity) {
        this.container = new LinkedList();
        this.e = new Semaphore(capacity);// the permit number of threads what can enqueue the queue
        //重要: enqueue方法里的d.release();会增加　d　的　permit数量。
        //就是每操作一次放元素进queue，就可以dequeue一次。
        this.d = new Semaphore(0);
    }

    public void enqueue(T obj) throws InterruptedException {
        e.acquire();
        container.offer(obj);
        d.release();
    }

    public T dequeue() throws InterruptedException {
        d.acquire();
        final T obj = container.poll();
        e.release();
        return obj;
    }

    public int size() {
        return container.size();
    }
}

/**
 * using condition
 */
class Queue4 {

    final Lock lock = new ReentrantLock();
    final Condition canPut = lock.newCondition();
    final Condition canGet = lock.newCondition();

    private int capacity;
    private Object[] container;
    //重要: 是队列不是栈，要先进先出，所以得用两个下标
    private int putptr, takeptr, count;

    public Queue4(int capacity) {
        container = new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(Object element) throws InterruptedException {
        lock.lock();
        try {
            while (count == container.length) {// 用while防止虚假唤醒
                canPut.await();
            }
            container[putptr] = element;
            //重要: 赋值这两个下标，当到头了，再从0开始
            if (++putptr == container.length) putptr = 0;
            ++count;
            canGet.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                canGet.await();
            }
            final Object obj = container[takeptr];
            if (++takeptr == container.length) takeptr = 0;
            --count;
            canPut.signal();
            return obj;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return container.length;
    }
}
