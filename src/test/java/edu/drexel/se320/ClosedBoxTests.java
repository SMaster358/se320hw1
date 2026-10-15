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

import java.net.spi.InetAddressResolver;
import java.util.NoSuchElementException;

public class ClosedBoxTests extends BinarySearchBase {
    Integer[] arr;
    @BeforeEach void setup() {
        arr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test void sortedArraySearchWorks() {
        int actual = binarySearchImplementation(arr, 1);
        assertEquals(1, actual);
    }

    @Test void testNoSuchElementException() {
        Exception exception = assertThrows(NoSuchElementException.class,() -> {
            binarySearchImplementation(arr, 11);
        });
        assertEquals("Element not found in array", exception.getMessage());
    }

    @Test void unsortedArrayThrowsException() {
        arr = new Integer[] {3, 1, 2, 6, 3, 4, 7};
        Exception exception = assertThrows(RuntimeException.class,() -> {
            binarySearchImplementation(arr, 6);
        });
        assertEquals("Array is not sorted", exception.getMessage());
    }

    @Test
    void illegalArrayArgumentThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            binarySearchImplementation(null, 6);
        });
        assertEquals("Illegal argument given", exception.getMessage());
    }

    @Test
    void illegalElementArgumentThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            binarySearchImplementation(arr, null);
        });
        assertEquals("Illegal argument given", exception.getMessage());
    }

    @Test
    void emptyArrayThrowsException() {
        arr = new Integer[]{};
        Exception exception = assertThrows(NoSuchElementException.class,() -> {
            binarySearchImplementation(arr, 0);
        });
        assertEquals("Element not found in array", exception.getMessage());
    }

    @Test
    void arraySizeOneFindsValue() {
        arr = new Integer[] {1};
        int actual = binarySearchImplementation(arr, 1);
        assertEquals(0, actual);
    }

    @Test
    void evenSizeArrayFindsValue() {
        arr = new Integer[] {1, 2, 3, 4};
        int actual = binarySearchImplementation(arr, 3);
        assertEquals(2, actual);
    }

    @Test
    void stringArrayStillSearchable() {
       String[] arr = new String[] {"Apple", "Banana"};
       int actual = binarySearchImplementation(arr, "Apple");
       assertEquals(0, actual);
    }

    @Test
    void duplicateValuesInArrayAreValidAndSelectsFirstEncountered() {
        arr = new Integer[] {1, 1 ,2, 3, 4, 5,6, 6};
        int actual = binarySearchImplementation(arr, 1);
        assertEquals(1, actual);
    }

    @Test
    void multipleIllegalArgsThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            binarySearchImplementation(null, null);
        });
        assertEquals("Illegal argument given", exception.getMessage());
    }

    @Test
    void getProperIndexWhenElementGreaterThanMiddle() {
        int actual = binarySearchImplementation(arr, 10);
        assertEquals(10, actual);
    }

    @Test
    void arraySizeOneThatDoesntContainElement() {
        arr = new Integer[]{1};
        Exception exception = assertThrows(NoSuchElementException.class,() -> {
            binarySearchImplementation(arr, 0);
        });
        assertEquals("Element not found in array", exception.getMessage());
    }

    @Test
    void arrayWithNegativesWorks() {
        arr = new Integer[]{-1, 0, 1, 2};
        int actual = binarySearchImplementation(arr, -1);
        assertEquals(0, actual);
    }
}

