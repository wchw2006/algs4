package edu.wcw;

import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class WFixCapactityTest {

    public static final int[] test = new int[1_0000];
    public static final Random random = new Random(System.currentTimeMillis());
    public static final int capactiy = 100;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt(10000);
        }
        Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < 1000; i++) {
//            ints();
            integers();
        }
        double time1 = stopwatch.elapsedTime();
        StdOut.printf(" (%.2f seconds)\n", time1);
    }

    public static void ints() throws Exception {
        WFixedCapacityStackOfInts stack = new WFixedCapacityStackOfInts(capactiy);
        for (int i = 0; i < test.length; i++) {
            if ((i + 1) % capactiy != 0) {
                stack.push(test[i]);
            } else {
                stack.push(test[i]);
                for (int y = 0; y < capactiy; y++) {
                    stack.pop();
                }
            }
        }
    }
    public static void integers() throws Exception {
        WFixedCapacityStack<Integer> stack = new WFixedCapacityStack<>(capactiy);
        for (int i = 0; i < test.length; i++) {
            if ((i + 1) % capactiy != 0) {
                stack.push(test[i]);
            } else {
                stack.push(test[i]);
                for (int y = 0; y < capactiy; y++) {
                    stack.pop();
                }
            }
        }
    }
}
