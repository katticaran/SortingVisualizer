package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
    public int index1;
    public int index2;
    
    public SwapEvent(int index1,int index2){
        this.index1 = index1;
        this.index2 = index2;
     }

    public boolean isEmphasized(){
        return true ;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> retList = new ArrayList<Integer>();
        retList.add(this.index1);
        retList.add(this.index2);
        return retList;
    }

    public void apply(T[] arr) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return;
    }
}


