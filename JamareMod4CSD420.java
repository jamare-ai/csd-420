package com.mycompany.mod4;

/*
 * Jamare McCallum
 * CSD420
 * Module 4
 *
 * This program creates a LinkedList and compares how long
 * it takes to go through the list using an Iterator and
 * using the get(index) method.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class JamareMod4CSD420 {

    public static void main(String[] args) {

        System.out.println("----- Testing 50,000 Integers -----");
        testList(50000);

        System.out.println();

        System.out.println("----- Testing 500,000 Integers -----");
        testList(500000);

        System.out.println();

        runTestCode();
    }

    public static void testList(int size) {

        LinkedList<Integer> numbers = new LinkedList<>();

        // Fill the list
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        long total = 0;

        // Iterator timing
        long startIterator = System.nanoTime();

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            total += iterator.next();
        }

        long endIterator = System.nanoTime();

        total = 0;

        // get(index) timing
        long startGet = System.nanoTime();

        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
        }

        long endGet = System.nanoTime();

        double iteratorTime =
                (endIterator - startIterator) / 1000000.0;

        double getTime =
                (endGet - startGet) / 1000000.0;

        System.out.printf("Iterator Time: %.3f ms%n",
                iteratorTime);

        System.out.printf("get(index) Time: %.3f ms%n",
                getTime);
    }

    /*
     * Test code to make sure everything works correctly.
     */
    public static void runTestCode() {

        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        int iteratorSum = 0;

        Iterator<Integer> iterator = testList.iterator();

        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        int getSum = 0;

        for (int i = 0; i < testList.size(); i++) {
            getSum += testList.get(i);
        }

        if (iteratorSum == 15 && getSum == 15) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}

/*
 * Results:
 *
 * I tested a LinkedList with 50,000 integers and then
 * again with 500,000 integers.
 *
 * The Iterator was faster than get(index) for both tests.
 * The difference got bigger when the list size increased.
 *
 * Chapter 20 explains that a LinkedList stores data in
 * connected nodes. An Iterator moves through the nodes
 * one at a time, which makes it faster for traversing
 * the list.
 *
 * The get(index) method is slower because it has to find
 * the position of an element each time it is called.
 * When the list gets larger, that process takes much
 * longer.
 *
 * Based on my results, Iterator is a better choice when
 * going through all elements in a LinkedList.
 */