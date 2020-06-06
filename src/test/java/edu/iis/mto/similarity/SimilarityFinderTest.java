package edu.iis.mto.similarity;

import edu.iis.mto.search.SearcherDubler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SimilarityFinderTest {

    SearcherDubler searcherDubler;
    SimilarityFinder similarityFinder;
    double expResult;
    double calcResult;

    @Test
    void CheckIfSequencesAreEmpty() {
        int[] sequenceOne = null;
        int[] sequenceTwo = null;
        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);

        assertThrows(
                NullPointerException.class,
                () -> this.similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));

    }

    @Test
    void CheckIfFirstSequenceIsEmpty() {
        int[] sequenceOne = null;
        int[] sequenceTwo = {1,4,6};
        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);

        assertThrows(
                NullPointerException.class,
                () -> this.similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));
    }

    @Test
    void CheckIfSecondSequenceIsEmpty() {
        int[] sequenceOne = {1,4,6};
        int[] sequenceTwo = null;
        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);

        assertThrows(
                NullPointerException.class,
                () -> this.similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));
    }

    @Test
    void CheckIfOneElementIsMatching() {
        int[] sequenceOne = {1,6,9};
        int[] sequenceTwo = {3,2,9};
        expResult = 0.2;

        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);
        calcResult = similarityFinder.calculateJackardSimilarity(sequenceOne,sequenceTwo);

        assertEquals(calcResult, expResult);
    }

    @Test
    void CheckIfNeitherElementIsMatching() {
        int[] sequenceOne = {1,4,6,8};
        int[] sequenceTwo = {2,3,5,7};
        expResult = 0.0;

        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);
        calcResult = similarityFinder.calculateJackardSimilarity(sequenceOne,sequenceTwo);

        assertEquals(calcResult, expResult);
    }

    @Test
    void CheckIfAllElementsMatching() {
        int[] sequenceOne = {2,7,5,8};
        int[] sequenceTwo = {2,7,8,5};
        expResult = 1.0;

        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);
        calcResult = similarityFinder.calculateJackardSimilarity(sequenceOne,sequenceTwo);

        assertEquals(calcResult, expResult);

    }


    @Test
    void CheckIfFirstParamInSearchInterfaceMethodIsProperly() {
        int[] sequenceOne = {3,2,9};
        int[] sequenceTwo = {};
        assertThrows(NullPointerException.class,
                () -> similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));
    }

    @Test
    void CheckIfSecondParamInSearchInterfaceMethodIsProperly() {
        int[] sequenceOne = {};
        int[] sequenceTwo = {3,2,9};
        assertThrows(NullPointerException.class,
                () -> similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));
    }

    @Test
    void CheckIfCounterIsProperlyImplemented() {
        int[] sequenceOne = {2,7,5,8};
        int[] sequenceTwo = {4,7,};

        searcherDubler = new SearcherDubler();
        searcherDubler.setSequence(sequenceTwo);
        similarityFinder = new SimilarityFinder(searcherDubler);

        similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo);
        assertEquals(4,this.searcherDubler.getCounter());
    }

    @Test
    void CheckIfAllParamsInSearchInterfaceMethodAreNULL() {
        int[] sequenceOne = {1,6,9};
        int[] sequenceTwo = {3,2,9};
        similarityFinder = new SimilarityFinder(null);
        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(sequenceOne, sequenceTwo));
    }

}