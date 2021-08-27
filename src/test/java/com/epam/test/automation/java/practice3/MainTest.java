package com.epam.test.automation.java.practice3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;


public class MainTest {

    @Test(dataProvider = "task1DataProvider")
    public void ifTask1ThenSuccess(List<Integer> currentValue, List<Integer> expectedValue) {
        //given
        var current = currentValue.stream().mapToInt(i -> i).toArray();
        var expected = expectedValue.stream().mapToInt(i -> i).toArray();
        //when
        var result = Main.task1(current);
        //then
        assertEquals(result, expected);
    }

    @Test(dataProvider = "task2DataProvider")
    public void ifTask2ThenSuccess(List<Integer> currentValue, int expectedValue) {
        //given
        var current = currentValue.stream().mapToInt(i -> i).toArray();
        //when
        var result = Main.task2(current);
        //then
        assertEquals(result, expectedValue);
    }

    @Test
    public void ifTask3ThenSuccess() {
        //given
        var current = new int[][]{{2, 4, 3, 3}, {5, 7, 8, 5}, {2, 4, 3, 3}, {5, 7, 8, 5}};
        var expected = new int[][]{{2, 1, 1, 1}, {0, 7, 1, 1}, {0, 0, 3, 1}, {0, 0, 0, 5}};
        //when
        var result = Main.task3(current);
        //then
        assertEquals(result, expected);
    }

    @DataProvider(name = "task1DataProvider")
    public static Object[][] task1DataProvider() {
        return new Object[][]{
                {List.of(10, 5, 3, 4), List.of(4, 5, 3, 10)},
                {List.of(100, 2, 3, 4, 5), List.of(100, 4, 3, 2, 5)},
                {List.of(100, 2, 3, 45, 33, 8, 4, 54), List.of(54, 4, 3, 45, 33, 8, 2, 100)},
                {List.of(100, 2, 4, 45, 33, 8, 4, 54), List.of(54, 4, 8, 45, 33, 4, 2, 100)}};
    }


    @DataProvider(name = "task2DataProvider")
    public static Object[][] task2DataProvider() {
        return new Object[][]{
                {List.of(4, 100, 3, 4), 0},
                {List.of(5, 50, 50, 4, 5), 1},
                {List.of(5, 350, 350, 4, 350), 3},
                {List.of(10, 10, 10, 10, 10), 4}
        };
    }
}