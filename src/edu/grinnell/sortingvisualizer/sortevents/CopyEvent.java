package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{

    public  T value;
    public int destination;
    
    public CopyEvent(T val, int dest) {
        this.value = val;
        this.destination = dest;
    }

    public boolean isEmphasized(){
        return true ;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> retList = new ArrayList<Integer>();
        retList.add(destination);
        return retList;                
    }

    public void apply(T[] arr) {
        arr[destination] = value;
        return;
    }
}
