package Searches;

import Utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    BinarySearch binarySearch ;
    @BeforeEach
    void setUp(){
        binarySearch = new BinarySearch();
    }
    @Test
    void find () {
        Integer[] array = TestUtils.randomIntegerSortedArray(1000,1,1000);
        for (int i = 0; i < 1000000000; i++) {
            int searchedElement = array[TestUtils.getRandomInt(1,999)];
            int expected = Arrays.binarySearch(array, searchedElement);
            int actual = binarySearch.find(array,searchedElement);
            assertEquals(expected , actual);
        }
    }
}