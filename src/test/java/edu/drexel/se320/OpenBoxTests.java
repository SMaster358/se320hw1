package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.lessThan;

// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class OpenBoxTests extends BinarySearchBase {

    Integer[] arr;

    @BeforeEach
    void setup() {
        arr = new Integer[] {1, 2, 3, 4, 5};
    }

    @Test
    public void coverageForCorrectInputs() {
        int actual = binarySearchImplementation(arr, 1);
        assertEquals(0, actual);
    }

    @Test
    void coverIndexOutOfBounds() {
        arr = new Integer[]{};

            Exception exception = assertThrows(NoSuchElementException.class,() -> {
                binarySearchImplementation(arr, 0);
            });
            assertEquals("Element not found in array", exception.getMessage());
        }

    @Test
    void coverInvalidArg() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            binarySearchImplementation(null, null);
        });
        assertEquals("Illegal argument given", exception.getMessage());
    }

    @Test
    void coverIfCasesForElementGreaterThanMiddle() {
        int actual = binarySearchImplementation(arr, 5);
        assertEquals(4, actual);
    }

    @Test
    void coverNotFoundException() {
        Exception exception = assertThrows(NoSuchElementException.class,() -> {
            binarySearchImplementation(arr, 6);
        });
        assertEquals("Element not found in array", exception.getMessage());
    }

    @Test
    void coverFirstNotSortedArrayException() {
        arr = new Integer[] {1, 3, 2,};
        Exception exception = assertThrows(RuntimeException.class,() -> {
            binarySearchImplementation(arr, 1);
        });
        assertEquals("Array is not sorted", exception.getMessage());
    }

    @Test
    void coverUnsortedArrayOfSizeTwo() {
        arr = new Integer[] {1, 0};
        Exception exception = assertThrows(RuntimeException.class,() -> {
            binarySearchImplementation(arr, 1);
        });
        assertEquals("Array is not sorted", exception.getMessage());
    }

    @Test
    void coverElseStatementException() {
        arr = new Integer[] {0, 2, 1};
        Exception exception = assertThrows(RuntimeException.class,() -> {
            binarySearchImplementation(arr, 1);
        });
        assertEquals("Array is not sorted", exception.getMessage());
    }

    @Test
    void coverNonInteger() {
        String[] arr = new String[]{"Apple", "Banana"};
        int actual = binarySearchImplementation(arr, "Apple");
        assertEquals(0, actual);
    }



}

