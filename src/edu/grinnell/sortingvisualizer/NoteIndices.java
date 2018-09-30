package edu.grinnell.sortingvisualizer;

import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {

    /**
     * @param n the size of the scale object that these indices map into
     */
    private Integer[] notes;
    private boolean[] highlights;

    public NoteIndices(int n) {
        // TODO: fill me in
        this.notes = new Integer[n];
        this.highlights = new boolean[n];
        for (int i=0;i<n;i++) {
            this.highlights[i] = false;
            this.notes[i] = i;
        }
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.highlights = new boolean[n];
        this.notes = new Integer[n];
        for (int i=0;i<n;i++) {
            this.highlights[i] = false;
            this.notes[i] = i;
        }
        RandomizeArray(this.notes);
    }

    public static Integer[] RandomizeArray(Integer[] array){
        Random rGen = new Random();         

        for (int i=0; i<array.length; i++) {
            int randomPosition = rGen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        // TODO: fill me in
        return this.notes;
    }

    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlights[index] = true;
    }

    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        // TODO: fill me in
        return this.highlights[index];
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i=0;i<this.highlights.length;i++) {
            this.highlights[i] = false;
        }
    }
}
