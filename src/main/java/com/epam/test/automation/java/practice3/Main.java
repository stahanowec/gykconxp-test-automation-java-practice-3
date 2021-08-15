package com.epam.test.automation.java.practice3;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private Main() {
    }

    public static int[] task1(int[] array) {
        if (array.length > 2) {
            for (var i = 0; i < array.length / 2; i++) {
                var num = array[i];
                var lastNum = array[array.length - i - 1];
                if (isPrime(num, lastNum)) {
                    array[i] = lastNum;
                    array[array.length - i - 1] = num;
                }
            }
            return array;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isPrime(int secondNum, int thirdNum) {
        return secondNum % 2 == 0 && thirdNum % 2 == 0;
    }

    public static int task2(int[] array) {
        if (array.length > 1) {
            Map<Integer, Pair> positions = new HashMap<>();
            for (var i = 0; i < array.length; i++) {
                var element = array[i];
                var lists = positions.get(element);
                if (lists == null) {
                    positions.put(element, Pair.of(i));

                } else {
                    lists.updateLast(i);
                }
            }

            var maxValue = positions.keySet().stream().max(Integer::compareTo)
                    .orElseThrow(IllegalArgumentException::new);
            var integerList = positions.get(maxValue);
            if (integerList.isNotPresentLast()) {
                return 0;
            }
            return integerList.calculate();
        }
        return 0;
    }

    public static int[][] task3(int[][] matrix) {
        if (matrix.length > 0) {
            var newMatrix = matrix.clone();
            for (var i = 0; i < matrix.length; i++) {
                for (var j = 0; j < matrix[i].length; j++) {
                    if (i == j) {
                        newMatrix[i][j] = matrix[i][j];
                    } else if (i < j) {
                        newMatrix[i][j] = 1;
                    } else {
                        newMatrix[i][j] = 0;
                    }
                }
            }
            return newMatrix;
        }
        throw new IllegalArgumentException();
    }

    public static class Pair {
        private final Integer first;
        private Integer last;

        private Pair(Integer first) {
            this.first = first;
        }

        public static Pair of(Integer first) {
            return new Pair(first);
        }

        public Pair updateLast(Integer last) {
            this.last = last;
            return this;
        }

        public boolean isNotPresentLast() {
            return last == null;
        }

        public int calculate() {
            return last - first;
        }
    }

}
