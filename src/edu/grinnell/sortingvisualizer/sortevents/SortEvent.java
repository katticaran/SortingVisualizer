package edu.grinnell.sortingvisualizer.sortevents;

import java.util.List;

public interface SortEvent<T> {
    // TODO: fill in the SortEvent<T> interface definition
    void apply(T[]  arr);
    List<Integer> getAffectedIndices();
    boolean isEmphasized();
     
}
