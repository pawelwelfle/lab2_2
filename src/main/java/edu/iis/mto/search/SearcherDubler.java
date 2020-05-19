package edu.iis.mto.search;

import java.util.HashMap;

public class SearcherDubler implements SequenceSearcher {
    private HashMap<Integer, Integer> sequence;
    private int counterOfSearchUse = 0;

    public void setSequence(int[] sequence) {
        HashMap<Integer, Integer> secondarySeq = new HashMap<>();
        if (sequence != null) {
            for (int i = 0; i < sequence.length; i++) {
                secondarySeq.put(sequence[i], i);
            }
        }
        this.sequence = secondarySeq;
    }

    @Override
    public SearchResult search(int elem, int[] seq) {
        if (seq == null) {
            throw new NullPointerException();
        }
        counterOfSearchUse++;

        if (this.sequence.containsKey(elem)) {
            return SearchResult.builder()
                    .withFound(true)
                    .withPosition(this.sequence.get(elem))
                    .build();
        }

        return SearchResult.builder()
                .withFound(false)
                .build();
    }
}
