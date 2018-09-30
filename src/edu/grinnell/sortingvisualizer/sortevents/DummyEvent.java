package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

// This Class is used to append to the end of the events list so as to remove
//all highlights at the end of the graphic display thereby giving us a 
//more visually appealing final result.
public class DummyEvent<T> implements SortEvent<T> {

        public boolean isEmphasized(){
            return false ;
        }

        public List<Integer> getAffectedIndices(){
            List<Integer> retList = new ArrayList<Integer>();
            return retList;
        }

        public void apply(T[] arr) {
            return;
        }
    }


