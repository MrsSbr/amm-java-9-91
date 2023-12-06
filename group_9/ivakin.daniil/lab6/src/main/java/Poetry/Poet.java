package Poetry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Poet extends Thread {
    private int currentLineIndex;
    private String poetName;
    private List<String> poem;
    private Tissue tissue;

    public Poet(String poetName) {
        super(poetName);
        this.currentLineIndex = 0;
        this.poetName = poetName;
        this.poem = new ArrayList<>();
        this.tissue = null;
    }

    public Poet(String poetName, Collection<String> poem) {
        super(poetName);
        this.currentLineIndex = 0;
        this.poetName = poetName;
        this.poem = new ArrayList<>();
        this.poem.addAll(poem);
        this.tissue = null;
    }

    public String getPoetName() {
        return poetName;
    }

    public List<String> getPoem() {
        return poem;
    }

    public void setPoem(List<String> poem) {
        this.poem = poem;
    }

    public Tissue getTissue() {
        return tissue;
    }

    public void setTissue(Tissue tissue) {
        this.tissue = tissue;
    }

    @Override
    public void run() {
        while (poem.size() > currentLineIndex) {
            writeLine();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void resetCurrentLineIndex() {
        currentLineIndex = 0;
    }

    private void writeLine() {
        synchronized (tissue) {
            tissue.addPoemLine(poem.get(currentLineIndex));
            currentLineIndex++;
        }
    }

}
