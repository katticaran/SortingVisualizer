package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T>{
    private int index1;
    private int index2;
    
   public CompareEvent(int index1,int index2){
       this.index1 = index1;
       this.index2 = index2;
    }
    
    public boolean isEmphasized(){
        return false;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> retList = new ArrayList<Integer>();
        retList.add(this.index1);
        retList.add(this.index2);
        return retList;
    }

    public void apply(T[] arr) {
        return;
    }
}
