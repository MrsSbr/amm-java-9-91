package Poetry;

import java.util.ArrayList;
import java.util.List;

public class Tissue {
    private List<String> poemLines;

    public Tissue() {
        poemLines = new ArrayList<>();
    }

    public List<String> getPoemLines() {
        return poemLines;
    }

    public void setPoemLines(List<String> poemLines) {
        this.poemLines = poemLines;
    }

    public void addPoemLine(String poemLine) {
        poemLines.add(poemLine);
    }
}
