package com.mycompany.mod6bubblesort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Jamare McCallum
 * CSD420
 * Module 6 Programming Assignment
 * Bubble Sort Using Generics
 */

public class Mod6BubbleSort {

    // Sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        E temp;

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {

                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Sort using Comparator
    public static <E> void bubbleSort(E[] list,
            Comparator<? super E> comparator) {

        E temp;

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {

                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Test Integer array
        Integer[] numbers = {9, 4, 2, 8, 1, 5};

        System.out.println("Before sort:");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(numbers));

        // Test String array
        String[] names = {"Sue", "Bob", "John", "Amy"};

        System.out.println("\nBefore sort:");
        System.out.println(Arrays.toString(names));

        bubbleSort(names);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(names));

        // Test Comparator descending order
        Integer[] test = {9, 4, 2, 8, 1, 5};

        System.out.println("\nBefore descending sort:");
        System.out.println(Arrays.toString(test));

        bubbleSort(test, (a, b) -> b.compareTo(a));

        System.out.println("After descending sort:");
        System.out.println(Arrays.toString(test));
    }
}