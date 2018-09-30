package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        // TODO: fill me in
        super.paintComponent(g);
        int numNotes = this.notes.getNotes().length;
        int width = this.getPreferredSize().width / numNotes;
        int heightFactor = this.getPreferredSize().height / numNotes;

        for(int i = 0; i < numNotes; i++){

            float red = 0;
            float green = ((float)i/(float)numNotes);
            float blue = 1 - ((float)i/(float)numNotes);

            Color noHighColor = new Color(red,green,blue);
            Color highColor = new Color((float)1,0,0);

            if(notes.isHighlighted(i)){
                g.setColor(highColor);
            }
            else {
                g.setColor(noHighColor);
            }
            g.fillRect(width*i, this.getPreferredSize().height-(heightFactor*(notes.getNotes()[i]+1)),
                    width, heightFactor*(notes.getNotes()[i]+1));
        }

    }

}
