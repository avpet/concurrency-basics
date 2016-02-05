package com.oleksiipetinov.javatests.dining_philosophers.solution1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(BlockJUnit4ClassRunner.class)
public class DiningPhilosophersTest {
    static final int COUNT = 5;

    @Test
    public void testDinner() throws Exception {
        Configuration configuration = new Configuration(1000,800,10);

        ExecutorService executor = Executors.newFixedThreadPool(COUNT);

        Chopstick[] chopsticks = new Chopstick[COUNT];
        for (int i = 0; i < COUNT; i++)
            chopsticks[i] = new Chopstick();

        Philosopher[] p = new Philosopher[COUNT];
        for (int i = 0; i < COUNT; i++) {
            p[i] = new Philosopher(String.valueOf(i), chopsticks[i], chopsticks[(i + 1) % COUNT], configuration);
        }

        for (int i = 0; i < COUNT; i++) {
            executor.submit(p[i]);
        }

        executor.shutdown();

        assertTrue(executor.awaitTermination(120L, TimeUnit.SECONDS));

        for (int i = 0; i < COUNT; i++) {
            assertTrue(p[i].hadThoughts());
            assertTrue(p[i].hadFood());
        }
    }
}
