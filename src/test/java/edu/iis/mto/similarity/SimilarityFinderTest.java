package edu.iis.mto.similarity;

import edu.iis.mto.search.SearcherDubler;
import org.junit.jupiter.api.Test;


class SimilarityFinderTest {

    SearcherDubler searcherDubler;

    //testy stanu
    @Test
    void CheckIfSequencesAreEmpty() {
        int[] sequenceOne = null;
        int[] sequenceTwo = null;


    }

    @Test
    void CheckIfFirstSequenceIsEmpty() {
        int[] sequenceOne = null;
        int[] sequenceTwo = {1,4,6};
    }

    @Test
    void CheckIfSecondSequenceIsEmpty() {
        int[] sequenceOne = {1,4,6};
        int[] sequenceTwo = null;
    }

    @Test
    void CheckIfOneElementIsMatching() {
        int[] sequenceOne = {1,4,6,9};
        int[] sequenceTwo = {3,2,5,9};
    }

    @Test
    void CheckIfNeitherElementIsMatching() {
        int[] sequenceOne = {1,4,6,8};
        int[] sequenceTwo = {2,3,5,7};
    }

    @Test
    void CheckIfAllElementsMatching() {
        int[] sequenceOne = {2,7,5,8};
        int[] sequenceTwo = {2,7,8,5};
    }

    //testy zachowania
    @Test
    void CheckIfSearchMethodInInterfaceIsProperlyUsed() {
    }

    @Test
    void CheckIfFirstParamInSearchInterfaceMethodIsProperly() {
    }

    @Test
    void CheckIfSecondParamInSearchInterfaceMethodIsProperly() {
    }

    @Test
    void CheckIfAllParamsInSearchInterfaceMethodAreUsedProperly() {
    }

    @Test
    void CheckIfAllParamsInSearchInterfaceMethodAreNULL() {
    }

    @Test
    void CheckIfSearchInterfaceMethodIsEmpty() {
    }
}