package Poetry;

import java.util.ArrayList;
import java.util.List;

public class InspirationProcess {
    private Tissue tissue;
    private List<Poet> poets;

    public InspirationProcess() {
        tissue = new Tissue();
        poets = new ArrayList<>();
    }

    public InspirationProcess(List<Poet> poets) {
        this.tissue = new Tissue();
        this.poets = poets;

        for (Poet poet : this.poets) {
            poet.setTissue(this.tissue);
        }
    }

    public Tissue getTissue() {
        return tissue;
    }

    public List<Poet> getPoets() {
        return poets;
    }

    public void setTissue(Tissue tissue) {
        this.tissue = tissue;

        for (Poet poet : this.poets) {
            poet.setTissue(this.tissue);
        }
    }

    public void setPoets(List<Poet> poets) {
        this.poets = poets;
    }

    public void addPoet(Poet poet) {
        poet.setTissue(tissue);
        this.poets.add(poet);
    }

    public List<String> beginInspitrationProcces() {
        for(Poet poet : poets) {
            poet.start();
        }

        for(Poet poet : poets) {
            try {
                poet.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return tissue.getPoemLines();
    }
}
