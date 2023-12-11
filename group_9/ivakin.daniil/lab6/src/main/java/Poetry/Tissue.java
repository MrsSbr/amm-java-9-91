package Poetry;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Tissue {
    private ConcurrentLinkedQueue<String> poemLines;

    public Tissue() {
        poemLines = new ConcurrentLinkedQueue<>();
    }

    public ConcurrentLinkedQueue<String> getPoemLines() {
        return poemLines;
    }

    public void setPoemLines(ConcurrentLinkedQueue<String> poemLines) {
        this.poemLines = poemLines;
    }

    public void addPoemLine(String poemLine) {
        poemLines.add(poemLine);
    }
}
